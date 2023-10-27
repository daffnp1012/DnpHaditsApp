package com.dnpstudio.dnphaditsapp.service

import com.dnpstudio.dnphaditsapp.response.HadistResponse
import com.dnpstudio.dnphaditsapp.response.PerawiResponse
import com.dnpstudio.dnphaditsapp.response.SearchHadistResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HaditsAPI {

    companion object{
        fun create(): HaditsAPI {
            return Retrofit.Builder()
                .baseUrl("https://hadis-api-id.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HaditsAPI::class.java)
        }
    }

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