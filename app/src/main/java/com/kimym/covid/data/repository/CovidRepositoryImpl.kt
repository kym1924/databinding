package com.kimym.covid.data.repository

import com.kimym.covid.data.api.InfectionService
import com.kimym.covid.data.api.VaccineService
import com.kimym.covid.data.entity.InfectionInformation
import com.kimym.covid.data.entity.VaccineInformation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(
    private val infectionService: InfectionService,
    private val vaccineService: VaccineService
) : CovidRepository {
    override fun getInfectionInformation(): Flow<InfectionInformation> {
        return flow {
            emit(infectionService.getInfectionInformation())
        }
    }

    override fun getVaccineInformation(): Flow<VaccineInformation> {
        return flow {
            emit(vaccineService.getVaccineInformation())
        }
    }
}
