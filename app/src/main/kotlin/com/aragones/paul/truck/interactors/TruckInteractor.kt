package com.aragones.paul.truck.interactors

import com.aragones.paul.truck.models.TruckResponse
import rx.Observable

interface TruckInteractor {
    fun car(manufacturerKey: String = "", modelKey: String = ""): Observable<TruckResponse>
}