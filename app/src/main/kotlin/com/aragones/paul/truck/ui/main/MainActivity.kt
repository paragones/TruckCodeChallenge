package com.aragones.paul.truck.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.aragones.paul.truck.R
import com.aragones.paul.truck.ui.dialog.RequestType
import com.aragones.paul.truck.ui.dialog.DialogActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        manufacturerCardView.setOnClickListener{
            startActivityForResult(DialogActivity.intent(this, RequestType.MANUFACTURER), REQUEST_MANUFATURER)
        }
        modelCardView.setOnClickListener{
            startActivityForResult(DialogActivity.intent(this, RequestType.MODEL), REQUEST_MODEL)
        }
        yearCardView.setOnClickListener{
            startActivityForResult(DialogActivity.intent(this, RequestType.YEAR), REQUEST_YEAR)
        }
        summaryCardView.setOnClickListener{
            startActivityForResult(DialogActivity.intent(this, RequestType.SUMMARY), REQUEST_YEAR)
        }
    }

    companion object {
        val REQUEST_MANUFATURER = 11
        val REQUEST_MODEL = 22
        val REQUEST_YEAR = 33
        val REQUEST_SUMMARY = 44

    }
}
