package com.kimym.covid.data.entity

import com.google.gson.annotations.SerializedName

data class VaccineInformation(
    @SerializedName("data")
    val data: List<VaccineEntity>
)

data class VaccineEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sido")
    val region: String,
    @SerializedName("firstCnt")
    val firstCnt: Int,
    @SerializedName("secondCnt")
    val secondCnt: Int,
    @SerializedName("thirdCnt")
    val thirdCnt: Int,
    @SerializedName("totalFirstCnt")
    val totalFirstCnt: Int,
    @SerializedName("totalSecondCnt")
    val totalSecondCnt: Int,
    @SerializedName("totalThirdCnt")
    val totalThirdCnt: Int
)

data class VaccineLevelEntity(
    val id: Int,
    val region: String,
    val count: Int,
    val totalCount: Int
)
