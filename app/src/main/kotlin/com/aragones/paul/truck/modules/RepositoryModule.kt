package com.aragones.paul.truck.modules

import com.aragones.paul.truck.repositories.CarRepository
import com.aragones.paul.truck.repositories.CarRepositoryImpl
import com.aragones.paul.truck.rest.CarRest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesTruckRepository(rest: CarRest): CarRepository = CarRepositoryImpl(rest)
}