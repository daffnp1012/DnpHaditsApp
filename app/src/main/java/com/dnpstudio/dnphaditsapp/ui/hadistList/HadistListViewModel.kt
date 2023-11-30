package com.dnpstudio.dnphaditsapp.ui.hadistList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dnpstudio.dnphaditsapp.data.di.AppModuleImpl
import com.dnpstudio.dnphaditsapp.data.repository.HaditsRepository
import com.dnpstudio.dnphaditsapp.item.state.HadistListState
import com.dnpstudio.dnphaditsapp.ui.navArgs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HadistListViewModel(
    private val repository: HaditsRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val perawi = savedStateHandle.navArgs<HadistListScreenNavArgs>().perawi

    var perawiName by mutableStateOf("")
        private set

    val hadistList = repository.getHaditsList(
        perawiSlug = perawi,
        perawiName = {
            perawiName = it
        }
    ).cachedIn(viewModelScope)
}