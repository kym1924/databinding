package com.kimym.covid.data.entity

import com.kimym.covid.R

enum class VaccinationLevel(val level: Int) {
    FIRST(R.id.chip_vaccine_first),
    COMPLETED(R.id.chip_vaccine_completed),
    ADDITIONAL(R.id.chip_vaccine_additional)
}
