package com.aragones.paul.truck.repositories

import com.aragones.paul.truck.models.CarResponse
import rx.Observable

interface CarRepository {
    fun car(manufacturerKey: String, modelKey: String): Observable<CarResponse>
}