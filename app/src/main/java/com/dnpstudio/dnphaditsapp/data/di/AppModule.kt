package com.dnpstudio.dnphaditsapp.data.di

import com.dnpstudio.dnphaditsapp.data.repository.HaditsRepository
import com.dnpstudio.dnphaditsapp.data.repository.HaditsRepositoryImpl
import com.dnpstudio.dnphaditsapp.data.source.remote.HaditsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppModule {
    val hadithApi: HaditsAPI
    val hadithRepository: HaditsRepository
}

object AppModuleImpl: AppModule{

    override val hadithApi: HaditsAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://hadis-api-id.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HaditsAPI::class.java)

    }

    override val hadithRepository: HaditsRepository by lazy {
        HaditsRepositoryImpl(hadithApi)
    }

}