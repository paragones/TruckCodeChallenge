package com.aragones.paul.truck.ui.main

import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.schedulers.ThreadScheduler
import com.aragones.paul.truck.ui.base.BasePresenter
import com.aragones.paul.truck.ui.dialog.RequestType
import javax.inject.Inject

/**
 * Auto1CodeChallenge
 *
 * Created by Paul Aragones on 9/24/2017.
 */
class MainPresenter @Inject constructor(scheduler: ThreadScheduler) : BasePresenter<MainView>(scheduler) {

    fun isRequestTypeValid(type: RequestType, car: Car): Boolean {
        when (type) {
            RequestType.MANUFACTURER -> {
                view?.cleanValues()
            }
            RequestType.MODEL -> {
                if (car.manufacturerKey.isEmpty()) {
                    view?.displayError()
                    return false
                }
            }
            RequestType.YEAR -> {
                if (car.manufacturerKey.isEmpty() || car.modelKey.isEmpty()) {
                    view?.displayError()
                    return false
                }
            }
            RequestType.SUMMARY -> {
                if (car.manufacturerKey.isEmpty() || car.modelKey.isEmpty() || car.yearKey.isEmpty()) {
                    view?.displayError()
                    return false
                }
            }
        }
        return true
    }
}