package com.dnpstudio.dnphaditsapp.item.state

import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistListResponse

sealed class HadistListState {
    object Loading: HadistListState()
    data class Success(val list: HadistListResponse): HadistListState()
    data class Error(val message: String): HadistListState()
}