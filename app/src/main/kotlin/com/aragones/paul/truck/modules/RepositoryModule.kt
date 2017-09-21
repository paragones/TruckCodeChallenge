package com.aragones.paul.truck.modules

import com.aragones.paul.truck.repositories.TruckRepository
import com.aragones.paul.truck.repositories.TruckRepositoryImpl
import com.aragones.paul.truck.rest.TruckRest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesTruckRepository(rest: TruckRest): TruckRepository = TruckRepositoryImpl(rest)
}