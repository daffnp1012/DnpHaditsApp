package com.dnpstudio.dnphaditsapp.data.source.remote

import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistListResponse
import com.dnpstudio.dnphaditsapp.data.source.remote.model.PerawiResponse
import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HaditsAPI {

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}")
    suspend fun getHaditsList(
        @Path("perawiSlug") perawiSlug: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): HadistListResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
    suspend fun getHadits(
        @Path("perawiSlug") perawi: String,
        @Path("nomorHadis") nomorHadis: Int
    ): HadistResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
    suspend fun search(
        @Path("perawiSlug") perawi: String,
        @Path("nomorHadis") nomorHadis: Int
    ): HadistResponse
}