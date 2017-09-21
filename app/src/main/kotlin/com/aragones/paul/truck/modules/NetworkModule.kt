package com.aragones.paul.truck.modules

import com.aragones.paul.truck.BuildConfig
import com.aragones.paul.truck.rest.TruckRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCategoryRest(retrofit: Retrofit): TruckRest = retrofit.create(TruckRest::class.java)

    @Provides
    @Singleton
    fun provideDefaultRestAdapter(): Retrofit = defaultRetrofit().build()

    private fun defaultRetrofit(): Retrofit.Builder {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
    }
}

