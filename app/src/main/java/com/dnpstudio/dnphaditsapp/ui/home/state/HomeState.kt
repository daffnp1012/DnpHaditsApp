package com.dnpstudio.dnphaditsapp.ui.home.state

import com.dnpstudio.dnphaditsapp.data.source.remote.model.PerawiResponse

sealed class HomeState{
    object Loading: HomeState()
    data class Success(val list: PerawiResponse): HomeState()
    data class Error(val message: String): HomeState()
}
