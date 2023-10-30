package com.dnpstudio.dnphaditsapp.data.service

import com.dnpstudio.dnphaditsapp.data.model.HadistResponse
import com.dnpstudio.dnphaditsapp.data.model.PerawiResponse
import com.dnpstudio.dnphaditsapp.data.model.SearchHadistResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HaditsAPI {

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}{page}{limit}")
    suspend fun getHadits(
        @Path("perawiSlug") perawiSlug: String,
        @Path("page") page: Int,
        @Path("limit") limit: Int = 20
    ): HadistResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
    suspend fun search(
        @Path("perawiSlug") perawi: String,
        @Path("nomorHadis") nomorHadis: Int
    ): SearchHadistResponse
}