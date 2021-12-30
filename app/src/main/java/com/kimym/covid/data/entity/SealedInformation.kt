package com.kimym.covid.data.entity

sealed class SealedInformation {
    data class InfectionItem(val infectionEntity: InfectionEntity) : SealedInformation() {
        override val seq: Int = infectionEntity.seq
    }

    data class VaccineItem(val vaccineLevelEntity: VaccineLevelEntity) : SealedInformation() {
        override val seq: Int = vaccineLevelEntity.id
    }

    object Header : SealedInformation() {
        override val seq = Int.MIN_VALUE
    }

    abstract val seq: Int
}
