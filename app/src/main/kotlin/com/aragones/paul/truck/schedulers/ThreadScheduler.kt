package com.aragones.paul.truck.schedulers

import rx.Observable

interface ThreadScheduler {
    fun <T> compose(): Observable.Transformer<T, T>
}