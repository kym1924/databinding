package com.kimym.covid.data.repository

import com.kimym.covid.data.entity.InfectionInformation
import com.kimym.covid.data.entity.VaccineInformation
import kotlinx.coroutines.flow.Flow

interface CovidRepository {
    fun getInfectionInformation(): Flow<InfectionInformation>

    fun getVaccineInformation(): Flow<VaccineInformation>
}
