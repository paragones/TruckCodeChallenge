package com.aragones.paul.truck.repositories

import com.aragones.paul.truck.BuildConfig
import com.aragones.paul.truck.models.TruckResponse
import com.aragones.paul.truck.rest.TruckRest
import rx.Observable
import rx.schedulers.Schedulers

class TruckRepositoryImpl(val truckRest: TruckRest) : TruckRepository {

    override fun manufacturers(): Observable<TruckResponse> {
        return truckRest.manufacturer(BuildConfig.CODE_KEY)
                .subscribeOn(Schedulers.io())
    }
}