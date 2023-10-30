package com.dnpstudio.dnphaditsapp.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dnpstudio.dnphaditsapp.data.di.Injection
import com.dnpstudio.dnphaditsapp.data.service.HaditsAPI
import com.dnpstudio.dnphaditsapp.ui.home.HomeViewModel

class ViewModelFactory(
    private val api: HaditsAPI
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when{
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(api) as T
            else -> throw Throwable("Unknown ViewModel Class" + modelClass.name)
        }

    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory = INSTANCE ?: synchronized(this){
            INSTANCE ?: ViewModelFactory(Injection.ApiProvider())
        }.also { INSTANCE = it }
    }
}