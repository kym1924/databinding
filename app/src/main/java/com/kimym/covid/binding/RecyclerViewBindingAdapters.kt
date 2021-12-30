package com.kimym.covid.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kimym.covid.base.BaseCovidAdapter
import com.kimym.covid.data.entity.VaccinationLevel
import com.kimym.covid.data.entity.VaccineEntity
import com.kimym.covid.data.entity.VaccineLevelEntity

@BindingAdapter(value = ["addHeaderAndSubmitList", "selectedLevel"], requireAll = false)
fun RecyclerView.addHeaderAndSubmitList(list: List<*>, selectedLevel: Int) {
    if (adapter != null) {
        with(adapter as BaseCovidAdapter) {
            when (selectedLevel) {
                0 -> addHeaderAndSubmitList(list)
                else -> addHeaderAndSubmitList(getVaccineLevelEntity(list, selectedLevel))
            }
        }
    }
}

private fun getVaccineLevelEntity(
    list: List<*>,
    level: Int
): MutableList<VaccineLevelEntity> {
    return mutableListOf<VaccineLevelEntity>().apply {
        list.forEach {
            with(it as VaccineEntity) {
                when (level) {
                    VaccinationLevel.FIRST.level -> {
                        add(VaccineLevelEntity(id, region, firstCnt, totalFirstCnt))
                    }
                    VaccinationLevel.COMPLETED.level -> {
                        add(VaccineLevelEntity(id, region, secondCnt, totalSecondCnt))
                    }
                    VaccinationLevel.ADDITIONAL.level -> {
                        add(VaccineLevelEntity(id, region, thirdCnt, totalThirdCnt))
                    }
                }
            }
        }
    }
}
