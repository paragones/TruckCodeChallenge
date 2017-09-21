package com.aragones.paul.truck.modules

import com.aragones.paul.truck.interactors.TruckInteractor
import com.aragones.paul.truck.interactors.TruckInteractorImpl
import com.aragones.paul.truck.repositories.TruckRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesTruckInteractor(repository: TruckRepository): TruckInteractor
            = TruckInteractorImpl(repository)
}