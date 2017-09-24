package com.aragones.paul.truck.presenter

import com.aragones.paul.truck.interactors.CarInteractor
import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.models.CarResponse
import com.aragones.paul.truck.scheduler.TestScheduler
import com.aragones.paul.truck.schedulers.ThreadScheduler
import com.aragones.paul.truck.ui.dialog.DialogPresenter
import com.aragones.paul.truck.ui.dialog.DialogView
import com.aragones.paul.truck.ui.dialog.RequestType
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import rx.Observable

/**
 * Auto1CodeChallenge
 *
 * Created by Paul Aragones on 9/24/2017.
 */
class DialogPresenterTest {
    private lateinit var presenter: DialogPresenter
    private lateinit var interactor: CarInteractor
    private lateinit var scheduler: ThreadScheduler
    private lateinit var view: DialogView
    private lateinit var car: Car
    private lateinit var carResponse: CarResponse

    @Before
    fun setup() {
        interactor = Mockito.mock(CarInteractor::class.java)
        scheduler = Mockito.mock(ThreadScheduler::class.java)
        view = Mockito.mock(DialogView::class.java)
        car = Car()
        presenter = DialogPresenter(interactor, TestScheduler())
        presenter.attach(view)
        carResponse = CarResponse(mapOf(Pair("", "")))
    }

    @Test
    fun shouldLoadDataOnChosenManufacturer() {
        Mockito.`when`(interactor.car(car.manufacturerKey, car.modelKey))
                .thenReturn(Observable.just(CarResponse(mapOf(Pair<String, String>("", "")))))

        presenter.setupView(RequestType.MANUFACTURER, car)
        Mockito.verify(view, Mockito.times(1)).displayCarResponse(carResponse.carMap)
    }
}