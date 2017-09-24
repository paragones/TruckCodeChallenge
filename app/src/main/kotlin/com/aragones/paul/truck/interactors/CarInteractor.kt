package com.aragones.paul.truck.interactors

import com.aragones.paul.truck.models.CarResponse
import rx.Observable

interface CarInteractor {
    fun car(manufacturerKey: String = "", modelKey: String = ""): Observable<CarResponse>
}