package com.aragones.paul.truck.modules

import com.aragones.paul.truck.interactors.CarInteractor
import com.aragones.paul.truck.interactors.CarInteractorImpl
import com.aragones.paul.truck.repositories.CarRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesTruckInteractor(repository: CarRepository): CarInteractor
            = CarInteractorImpl(repository)
}