package com.aragones.paul.truck.interactors

import com.aragones.paul.truck.models.TruckResponse
import com.aragones.paul.truck.repositories.TruckRepository
import rx.Observable


class TruckInteractorImpl(val truckRepository: TruckRepository) : TruckInteractor {

    override fun car(manufacturerKey: String, modelKey: String): Observable<TruckResponse> =
            truckRepository.car(manufacturerKey, modelKey)
}