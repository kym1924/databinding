package com.kimym.covid.di

import com.kimym.covid.data.api.InfectionService
import com.kimym.covid.data.api.VaccineService
import com.kimym.covid.data.repository.CovidRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideCovidRepository(
        infectionService: InfectionService,
        vaccineService: VaccineService
    ): CovidRepositoryImpl {
        return CovidRepositoryImpl(infectionService, vaccineService)
    }
}
