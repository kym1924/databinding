package com.kimym.covid.di

import com.kimym.covid.data.api.InfectionService
import com.kimym.covid.data.api.VaccineService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    @Named("infection")
    fun provideInfectionRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://openapi.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @Named("vaccine")
    fun provideVaccineRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideInfectionService(@Named("infection") retrofit: Retrofit): InfectionService =
        retrofit.create(InfectionService::class.java)

    @Provides
    @Singleton
    fun provideVaccineService(@Named("vaccine") retrofit: Retrofit): VaccineService =
        retrofit.create(VaccineService::class.java)
}
