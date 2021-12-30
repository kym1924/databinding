package com.kimym.covid.domain.usecase

import com.kimym.covid.data.entity.InfectionInformation
import com.kimym.covid.data.repository.CovidRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetInfectionInformationUseCase @Inject constructor(
    private val covidRepository: CovidRepository
) {
    operator fun invoke(
        onStart: () -> Unit,
        catch: (String) -> Unit
    ): Flow<InfectionInformation> {
        return covidRepository.getInfectionInformation()
            .onStart { onStart() }
            .catch { catch("A problem has occurred. Please check.") }
    }
}
