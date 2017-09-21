package com.aragones.paul.truck.modules

import com.aragones.paul.truck.schedulers.ObserveOnScheduler
import com.aragones.paul.truck.schedulers.ThreadScheduler
import dagger.Module
import dagger.Provides
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class ExecutorsModule {
    private val postExecutionThread = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    fun provideObserveExecutor(): ThreadScheduler = ObserveOnScheduler(postExecutionThread)
}