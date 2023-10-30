package com.dnpstudio.dnphaditsapp.data.di

import com.dnpstudio.dnphaditsapp.data.service.HaditsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    fun ApiProvider(): HaditsAPI {
        return Retrofit.Builder()
            .baseUrl("https://hadis-api-id.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HaditsAPI::class.java)
    }
}