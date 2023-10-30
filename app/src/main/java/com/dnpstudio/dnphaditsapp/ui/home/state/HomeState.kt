package com.dnpstudio.dnphaditsapp.ui.home.state

import com.dnpstudio.dnphaditsapp.data.model.HadistResponse

sealed class HomeState{
    object Loading: HomeState()
    data class Success(val data: HadistResponse): HomeState()
    data class Error(val message: String): HomeState()
}
