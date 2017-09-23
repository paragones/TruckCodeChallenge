package com.aragones.paul.truck.repositories

import com.aragones.paul.truck.models.TruckResponse
import rx.Observable

interface TruckRepository {
    fun car(manufacturerKey: String, modelKey: String): Observable<TruckResponse>
}