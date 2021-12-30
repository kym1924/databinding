package com.kimym.covid.data.entity

import com.google.gson.annotations.SerializedName

data class InfectionInformation(
    @SerializedName("response")
    val response: ResponseInfection
)

data class ResponseInfection(
    @SerializedName("header")
    val header: ResponseInfectionHeader,
    @SerializedName("body")
    val body: ResponseInfectionBody
)

data class ResponseInfectionHeader(
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMsg")
    val resultMsg: String
)

data class ResponseInfectionBody(
    @SerializedName("items")
    val items: InfectionList
)

data class InfectionList(
    @SerializedName("item")
    val item: List<InfectionEntity>
)

data class InfectionEntity(
    @SerializedName("seq")
    val seq: Int,
    @SerializedName("gubun")
    val koreanName: String,
    @SerializedName("gubunEn")
    val englishName: String,
    @SerializedName("defCnt")
    val defCnt: Int,
    @SerializedName("incDec")
    val incDec: Int,
    @SerializedName("deathCnt")
    val deathCnt: Int,
    @SerializedName("localOccCnt")
    val localOccCnt: Int,
    @SerializedName("overFlowCnt")
    val overFlowCnt: Int,
    @SerializedName("isolClearCnt")
    val isolationClearCnt: Int
)
