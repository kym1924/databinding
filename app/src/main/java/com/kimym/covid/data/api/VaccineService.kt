package com.kimym.covid.data.api

import com.kimym.covid.data.entity.VaccineInformation
import com.kimym.covid.util.FormatDateUtil
import retrofit2.http.GET
import retrofit2.http.Query

interface VaccineService {
    @GET("api/15077756/v1/vaccine-stat")
    suspend fun getVaccineInformation(
        @Query("serviceKey") serviceKey: String = "",
        @Query("cond[baseDate::EQ]") baseDate: String = FormatDateUtil.getFormatDate("yyyy-MM-dd 00:00:00")
    ): VaccineInformation
}
