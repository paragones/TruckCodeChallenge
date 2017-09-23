package com.aragones.paul.truck.repositories

import com.aragones.paul.truck.BuildConfig
import com.aragones.paul.truck.models.TruckResponse
import com.aragones.paul.truck.rest.TruckRest
import rx.Observable
import rx.schedulers.Schedulers

class TruckRepositoryImpl(private val truckRest: TruckRest) : TruckRepository {

    override fun car(manufacturerKey: String, modelKey: String): Observable<TruckResponse> =
            when {
                manufacturerKey.isEmpty() && modelKey.isEmpty() -> manufacturer()
                !manufacturerKey.isEmpty() && modelKey.isEmpty() -> model(manufacturerKey)
               else -> year(manufacturerKey, modelKey)
            }

    private fun manufacturer() =
            truckRest.manufacturer(BuildConfig.CODE_KEY)
                    .subscribeOn(Schedulers.io())

    private fun model(manufacturerKey: String) =
            truckRest.model(BuildConfig.CODE_KEY, manufacturerKey)
                    .subscribeOn(Schedulers.io())

    private fun year(manufacturerKey: String, modelKey: String) =
            truckRest.year(BuildConfig.CODE_KEY, manufacturerKey, modelKey)
                    .subscribeOn(Schedulers.io())
}