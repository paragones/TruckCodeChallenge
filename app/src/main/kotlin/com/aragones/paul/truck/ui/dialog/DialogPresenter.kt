package com.aragones.paul.truck.ui.dialog

import android.util.Log
import com.aragones.paul.truck.interactors.CarInteractor
import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.models.CarResponse
import com.aragones.paul.truck.schedulers.ThreadScheduler
import com.aragones.paul.truck.ui.base.BasePresenter
import javax.inject.Inject

class DialogPresenter @Inject constructor(private val interactor: CarInteractor,
                                          scheduler: ThreadScheduler) : BasePresenter<DialogView>(scheduler) {
    fun setupView(type: RequestType, car: Car) {
        when (type) {
            RequestType.MANUFACTURER -> {
                loadData()
            }
            RequestType.MODEL -> {
                loadData(car.manufacturerKey)
            }
            RequestType.YEAR -> {
                loadData(car.manufacturerKey, car.modelKey)
            }
            RequestType.SUMMARY -> {
                view?.displaySummary()
            }
        }
    }

    private fun loadData(manufacturerKey: String = "",
                         modelKey: String = "") {
        view?.displayLoading()
        interactor.car(manufacturerKey, modelKey)
                .compose(observeOn<CarResponse>())
                .subscribe({
                    view?.hideLoading()
                    view?.displayCarResponse(it.carMap)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                    Log.e(this.javaClass.simpleName, "Error : ", it)
                })
    }
}