package com.aragones.paul.truck.ui.dialog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.aragones.paul.truck.R
import com.aragones.paul.truck.extension.gone
import com.aragones.paul.truck.extension.visible
import com.aragones.paul.truck.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dialog.*
import javax.inject.Inject


class DialogActivity : BaseActivity(), DialogView {
    // Declare Variables
//    var list: ListView
//    var adapter: ListViewAdapter
//    var editsearch: SearchView
//    var animalNameList: Array<String>
//    var arraylist = ArrayList<AnimalNames>()
    @Inject
    lateinit var presenter: DialogPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        component().inject(this)
        setupView()
        title = getString(R.string.title)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.loadData()
    }

    fun onQueryTextSubmit(query: String): Boolean {

        return false
    }

    fun onQueryTextChange(newText: String): Boolean {
//        adapter.filter(newText)
        return false
    }

    private fun loadCatFacts(limit: Int, page: Int) {
//        presenter.loadData(limit, page)
//        catFacts.text = limit.toString()
    }


    override fun displayManufacturers(data: Map<String, String>) {
        for (entry in data.entries) {
            Log.e(this.javaClass.simpleName, "key - ${entry.key}")
            Log.e(this.javaClass.simpleName, "value - ${entry.value}")
        }
//        // Pass results to ListViewAdapter Class
//        adapter = ListViewAdapter(this, arraylist)
//
//        // Binds the Adapter to the ListView
//        list.setAdapter(adapter)
//
//        // Locate the EditText in listview_main.xml
//        editsearch = findViewById(R.id.search) as SearchView
//        editsearch.setOnQueryTextListener(this)
//        mainRecyclerView.setHasFixedSize(true)
//        val mainAdapter = DialogAdapter(data, { shareCatFact(it) })
//        mainRecyclerView.layoutManager = LinearLayoutManager(this)
//        mainRecyclerView.adapter = mainAdapter
    }

    override fun displayLoading() {
        progress.visible()
        search.gone()
        listview.gone()
    }

    override fun hideLoading() {
        progress.gone()
        search.visible()
        listview.visible()
    }

    override fun displayError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
    }

    private fun shareCatFact(message: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.cat_fact_content, message))
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_cat_fact)))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        val KEY_REQUEST = "KEY_REQUEST"
        fun intent(context: Context, type: RequestType): Intent {
            val intent = Intent(context, DialogActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(KEY_REQUEST, type)
            intent.putExtras(bundle)
            return intent
        }
    }
}
