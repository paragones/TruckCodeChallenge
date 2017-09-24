package com.aragones.paul.truck.interactors

import com.aragones.paul.truck.models.CarResponse
import com.aragones.paul.truck.repositories.CarRepository
import rx.Observable


class CarInteractorImpl(val carRepository: CarRepository) : CarInteractor {

    override fun car(manufacturerKey: String, modelKey: String): Observable<CarResponse> =
            carRepository.car(manufacturerKey, modelKey)
}