package com.kimym.covid.data.api

import com.kimym.covid.data.entity.InfectionInformation
import com.kimym.covid.util.FormatDateUtil
import retrofit2.http.GET
import retrofit2.http.Query

interface InfectionService {
    @GET("openapi/service/rest/Covid19/getCovid19SidoInfStateJson")
    suspend fun getInfectionInformation(
        @Query("serviceKey") serviceKey: String = "",
        @Query("startCreateDt") startCreateDt: String = FormatDateUtil.getFormatDate("yyyyMMdd"),
        @Query("endCreateDt") endCreateDt: String = startCreateDt,
        @Query("_type") _type: String = "json"
    ): InfectionInformation
}
