package com.aragones.paul.truck.ui.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.SearchView
import android.widget.Toast
import com.aragones.paul.truck.R
import com.aragones.paul.truck.extension.gone
import com.aragones.paul.truck.extension.visible
import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dialog.*
import javax.inject.Inject


class DialogActivity : BaseActivity(), DialogView, SearchView.OnQueryTextListener {
    private lateinit var adapter: DialogAdapter
    private lateinit var type: RequestType
    private val car: Car = Car()

    @Inject
    lateinit var presenter: DialogPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        component().inject(this)
        extractBundle()
        setupView()
    }

    private fun extractBundle() {
        type = intent.extras.getSerializable(KEY_TYPE) as RequestType
        car.manufacturerKey = intent.extras.getString(KEY_MANUFACTURER)
        car.modelKey = intent.extras.getString(KEY_MODEL)
        car.yearKey = intent.extras.getString(KEY_YEAR)
        car.manufacturerValue = intent.extras.getString(VALUE_MANUFACTURER)
        car.modelValue = intent.extras.getString(VALUE_MODEL)
        car.yearValue = intent.extras.getString(VALUE_YEAR)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.setupView(type, car)
        setupSearchView()
    }

    override fun displaySummary() {
        search.gone()
        recyclerView.gone()
        progress.gone()
        chosenManufacturer.text = car.manufacturerValue
        chosenModel.text = car.modelValue
        chosenYear.text = car.yearValue
        llSummary.visible()
    }

    private fun setupSearchView() {
        search.setIconifiedByDefault(true);
        search.setFocusable(true);
        search.setIconified(false);
        search.requestFocusFromTouch();
    }

    override fun displayCarResponse(data: Map<String, String>) {
        adapter = DialogAdapter(data.toList(), { chooseOption(it) })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        search.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean = false

    override fun onQueryTextChange(newText: String): Boolean {
        adapter.filter(newText)
        return false
    }

    override fun displayLoading() {
        progress.visible()
        search.gone()
        recyclerView.gone()
        llSummary.gone()
    }

    override fun hideLoading() {
        progress.gone()
        search.visible()
        recyclerView.visible()
        llSummary.gone()
    }

    override fun displayError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
    }

    private fun chooseOption(result: Pair<String, String>) {
        val intent = Intent()
        intent.putExtras(Bundle().apply {
            putString(STRING_KEY, result.first)
            putString(STRING_VALUE, result.second)
        })
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        val STRING_KEY = "STRING_KEY"
        val STRING_VALUE = "STRING_VALUE"
        private val KEY_TYPE = "KEY_TYPE"
        private val KEY_MANUFACTURER = "KEY_MANUFACTURER"
        private val VALUE_MANUFACTURER = "VALUE_MANUFACTURER"
        private val KEY_MODEL = "KEY_MODEL"
        private val VALUE_MODEL = "VALUE_MODEL"
        private val KEY_YEAR = "KEY_YEAR"
        private val VALUE_YEAR = "VALUE_YEAR"
        fun intent(context: Context,
                   type: RequestType,
                   car: Car = Car()): Intent {
            val intent = Intent(context, DialogActivity::class.java)
            intent.putExtras(Bundle().apply {
                putSerializable(KEY_TYPE, type)
                putString(KEY_MANUFACTURER, car.manufacturerKey)
                putString(VALUE_MANUFACTURER, car.manufacturerValue)
                putString(KEY_MODEL, car.modelKey)
                putString(VALUE_MODEL, car.modelValue)
                putString(KEY_YEAR, car.yearKey)
                putString(VALUE_YEAR, car.yearValue)
            })
            return intent
        }
    }
}
