package com.dnpstudio.dnphaditsapp

import android.app.Application
import com.dnpstudio.dnphaditsapp.data.di.AppModule
import com.dnpstudio.dnphaditsapp.data.di.AppModuleImpl
import com.dnpstudio.dnphaditsapp.data.repository.HaditsRepository
import com.dnpstudio.dnphaditsapp.data.repository.HaditsRepositoryImpl

class DnpHaditsApp: Application(){
    companion object{
        lateinit var repository: HaditsRepository
        private lateinit var  appModule: AppModule
    }

    override fun onCreate(){
        super.onCreate()
        appModule = AppModuleImpl
        repository = HaditsRepositoryImpl(appModule.hadithApi)
    }
}
