package com.kimym.covid.presentation.vaccine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimym.covid.data.entity.VaccinationLevel
import com.kimym.covid.data.entity.VaccineEntity
import com.kimym.covid.domain.usecase.GetVaccineInformationUseCase
import com.kimym.covid.util.FormatDateUtil
import com.kimym.covid.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VaccineViewModel @Inject constructor(
    private val getVaccineInformationUseCase: GetVaccineInformationUseCase
) : ViewModel() {
    private val _vaccineList = MutableStateFlow<List<VaccineEntity>>(listOf())
    val vaccineList = _vaccineList.asStateFlow()

    private val _vaccineEntity = MutableStateFlow<Resource<VaccineEntity>>(Resource.loading(null))
    val vaccineEntity = _vaccineEntity.asStateFlow()

    val chipSelected = MutableStateFlow(VaccinationLevel.FIRST.level)

    val standardDate = FormatDateUtil.getFormatDate("MM.dd.")

    init {
        getVaccineInformation()
    }

    fun getVaccineInformation() {
        viewModelScope.launch {
            getVaccineInformationUseCase.invoke(
                onStart = { _vaccineEntity.value = Resource.loading(null) },
                catch = { _vaccineEntity.value = Resource.error(it, null) }
            ).collect { vaccineInformation ->
                val vaccineList = vaccineInformation.data
                _vaccineList.value = vaccineList.drop(1)
                _vaccineEntity.value = Resource.success(vaccineList.first())
            }
        }
    }
}
