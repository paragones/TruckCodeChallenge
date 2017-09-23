package com.aragones.paul.truck.ui.dialog

import android.util.Log
import com.aragones.paul.truck.interactors.TruckInteractor
import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.schedulers.ThreadScheduler
import com.aragones.paul.truck.ui.base.BasePresenter
import javax.inject.Inject

class DialogPresenter @Inject constructor(private val interactor: TruckInteractor,
                                          scheduler: ThreadScheduler) : BasePresenter<DialogView>(scheduler) {

    fun loadData(manufacturerKey: String = "",
                 modelKey: String = "") {
        view?.displayLoading()
        interactor.car(manufacturerKey, modelKey)
                .compose(observeOn())
                .subscribe({
                    view?.hideLoading()
                    view?.displayManufacturers(it.truckMap)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                    Log.e(this.javaClass.simpleName, "Error : ", it)
                })
    }
}