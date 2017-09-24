package com.aragones.paul.truck.presenter

import com.aragones.paul.truck.models.Car
import com.aragones.paul.truck.schedulers.ThreadScheduler
import com.aragones.paul.truck.ui.dialog.RequestType
import com.aragones.paul.truck.ui.main.MainPresenter
import com.aragones.paul.truck.ui.main.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Auto1CodeChallenge
 *
 * Created by Paul Aragones on 9/24/2017.
 */
class MainPresenterTest {
    lateinit var presenter: MainPresenter
    lateinit var scheduler: ThreadScheduler
    lateinit var view: MainView
    lateinit var car: Car

    @Before
    fun setup() {
        scheduler = Mockito.mock(ThreadScheduler::class.java)
        view = Mockito.mock(MainView::class.java)
        car = Car()
        presenter = MainPresenter(scheduler)
        presenter.attach(view)
    }

    @Test
    fun shouldClearValuesWhenUserChoseManufacturerView() {
        presenter.isRequestTypeValid(RequestType.MANUFACTURER, car)
        Mockito.verify(view, Mockito.times(1)).cleanValues()
    }

    @Test
    fun shouldReturnErrorWhenUserChoseModelViewAndCarManufacturerKeyIsEmpty() {
        presenter.isRequestTypeValid(RequestType.MODEL, car)
        Mockito.verify(view, Mockito.times(1)).displayError()
    }

    @Test
    fun shouldReturnErrorWhenUserChoseYearlyViewAndCarManufacturerOrModelKeyIsEmpty() {
        presenter.isRequestTypeValid(RequestType.YEAR, car)
        Mockito.verify(view, Mockito.times(1)).displayError()
    }

    @Test
    fun shouldReturnErrorWhenUserChoseSummaryViewAndSomeCarInfoIsEmpty() {
        presenter.isRequestTypeValid(RequestType.SUMMARY, car)
        Mockito.verify(view, Mockito.times(1)).displayError()
    }
}