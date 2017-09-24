package com.aragones.paul.truck.ui.dialog

interface DialogView {
    fun displayCarResponse(data: Map<String, String>)
    fun displayError()
    fun displayLoading()
    fun hideLoading()
    fun displaySummary()
}