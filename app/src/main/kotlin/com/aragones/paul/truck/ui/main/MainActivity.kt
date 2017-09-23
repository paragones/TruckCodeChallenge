package com.aragones.paul.truck.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.aragones.paul.truck.R
import com.aragones.paul.truck.extension.concatenateAlphaAnimations
import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.ui.base.BaseActivity
import com.aragones.paul.truck.ui.dialog.DialogActivity
import com.aragones.paul.truck.ui.dialog.RequestType
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    var car: Car = Car()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)
        concatenateAlphaAnimations(mutableListOf(rlManufacturer, rlModel, rlYear, rlSummary), 100L, 1f)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
        rlManufacturer.setOnClickListener {
            if (presenter.isRequestTypeValid(RequestType.MANUFACTURER, car)) startActivityForResult(DialogActivity.intent(this, RequestType.MANUFACTURER), REQUEST_MANUFACTURER)
        }
        rlModel.setOnClickListener {
            if (presenter.isRequestTypeValid(RequestType.MODEL, car)) startActivityForResult(DialogActivity.intent(this, RequestType.MODEL, car), REQUEST_MODEL)
        }
        rlYear.setOnClickListener {
            if (presenter.isRequestTypeValid(RequestType.YEAR, car)) startActivityForResult(DialogActivity.intent(this, RequestType.YEAR, car), REQUEST_YEAR)
        }
        rlSummary.setOnClickListener {
            if (presenter.isRequestTypeValid(RequestType.SUMMARY, car)) startActivityForResult(DialogActivity.intent(this, RequestType.SUMMARY, car), REQUEST_SUMMARY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_MANUFACTURER -> {
                    chosenManufacturer.text = data?.getStringExtra(DialogActivity.STRING_VALUE)
                    car.manufacturerKey = data?.extras?.getString(DialogActivity.STRING_KEY) as String
                    car.manufacturerValue = data?.extras?.getString(DialogActivity.STRING_VALUE) as String
                }
                REQUEST_MODEL -> {
                    chosenModel.text = data?.getStringExtra(DialogActivity.STRING_VALUE)
                    car.modelKey = data?.extras?.getString(DialogActivity.STRING_KEY) as String
                    car.modelValue = data?.extras?.getString(DialogActivity.STRING_VALUE) as String
                }
                REQUEST_YEAR -> {
                    chosenYear.text = data?.getStringExtra(DialogActivity.STRING_VALUE)
                    car.yearKey = data?.extras?.getString(DialogActivity.STRING_KEY) as String
                    car.yearValue = data?.extras?.getString(DialogActivity.STRING_VALUE) as String
                }
            }
        }
    }

    override fun cleanValues() {
        car.cleanValues()
        chosenManufacturer.text = getString(R.string.none_selected)
        chosenModel.text = getString(R.string.none_selected)
        chosenYear.text = getString(R.string.none_selected)
    }

    override fun displayError() = Toast.makeText(this, getString(R.string.load_error), Toast.LENGTH_LONG).show()

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        val REQUEST_MANUFACTURER = 11
        val REQUEST_MODEL = 22
        val REQUEST_YEAR = 33
        val REQUEST_SUMMARY = 44
    }
}
