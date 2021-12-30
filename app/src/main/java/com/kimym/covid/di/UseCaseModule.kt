package com.kimym.covid.di

import com.kimym.covid.data.repository.CovidRepositoryImpl
import com.kimym.covid.domain.usecase.GetInfectionInformationUseCase
import com.kimym.covid.domain.usecase.GetVaccineInformationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideInfectionUseCase(covidRepositoryImpl: CovidRepositoryImpl): GetInfectionInformationUseCase =
        GetInfectionInformationUseCase(covidRepositoryImpl)

    @Provides
    @ViewModelScoped
    fun provideVaccineUseCase(covidRepositoryImpl: CovidRepositoryImpl): GetVaccineInformationUseCase =
        GetVaccineInformationUseCase(covidRepositoryImpl)
}
