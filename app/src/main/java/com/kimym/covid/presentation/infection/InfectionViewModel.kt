package com.kimym.covid.presentation.infection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimym.covid.data.entity.InfectionEntity
import com.kimym.covid.domain.usecase.GetInfectionInformationUseCase
import com.kimym.covid.util.FormatDateUtil
import com.kimym.covid.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfectionViewModel @Inject constructor(
    private val getInfectionInformationUseCase: GetInfectionInformationUseCase,
) : ViewModel() {
    private val _infectionList = MutableStateFlow<List<InfectionEntity>>(listOf())
    val infectionList = _infectionList.asStateFlow()

    private val _infectionEntity =
        MutableStateFlow<Resource<InfectionEntity>>(Resource.loading(null))
    val infectionEntity = _infectionEntity.asStateFlow()

    val standardDate = FormatDateUtil.getFormatDate("MM.dd.")

    val yesterdayDate = FormatDateUtil.getFormatYesterday()

    init {
        getInfectionInformation()
    }

    fun getInfectionInformation() {
        viewModelScope.launch {
            getInfectionInformationUseCase.invoke(
                onStart = { _infectionEntity.value = Resource.loading(null) },
                catch = { _infectionEntity.value = Resource.error(it, null) }
            ).collect { infectionInformation ->
                val infectionList = infectionInformation.response.body.items.item
                _infectionList.value = infectionList.dropLast(1).sortedBy { it.incDec }.reversed()
                _infectionEntity.value = Resource.success(infectionList.last())
            }
        }
    }
}
