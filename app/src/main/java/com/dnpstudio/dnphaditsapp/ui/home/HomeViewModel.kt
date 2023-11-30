package com.dnpstudio.dnphaditsapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dnpstudio.dnphaditsapp.data.di.AppModuleImpl
import com.dnpstudio.dnphaditsapp.ui.home.event.HomeEvent
import com.dnpstudio.dnphaditsapp.ui.home.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _loadingStatus = MutableStateFlow<HomeState?>(null)
    val loadingStatus = _loadingStatus.asStateFlow()

    fun onEvent(
        event: HomeEvent
    ){
        when(event){
            is HomeEvent.getPerawi -> {
                viewModelScope.launch {
                    _loadingStatus.emit(HomeState.Loading)
                    try{
                        val response = AppModuleImpl.hadithRepository.getPerawi()
                        _loadingStatus.emit(HomeState.Success(response))
                    } catch (e: Exception){
                        _loadingStatus.emit(
                            HomeState.Error(e.message.toString())
                        )
                    }
                }
            }
        }
    }

}