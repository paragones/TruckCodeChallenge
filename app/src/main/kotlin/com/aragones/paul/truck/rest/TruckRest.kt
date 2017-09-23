package com.aragones.paul.truck.rest

import com.aragones.paul.truck.models.TruckResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface TruckRest {
    @GET("v1/car-types/manufacturer?page=0&pageSize=80")
    fun manufacturer(@Query("wa_key") key: String): Observable<TruckResponse>

    @GET("v1/car-types/main-types?page=0&pageSize=10")
    fun model(@Query("wa_key") key: String,
              @Query("manufacturer") manufacturerKey: String): Observable<TruckResponse>

    @GET("v1/car-types/built-dates")
    fun year(@Query("wa_key") key: String,
             @Query("manufacturer") manufacturerKey: String,
             @Query("main-type") modelKey: String): Observable<TruckResponse>
}