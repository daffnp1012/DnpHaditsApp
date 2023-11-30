package com.dnpstudio.dnphaditsapp.data.repository

import androidx.paging.PagingData
import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistListResponse
import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistResponse
import com.dnpstudio.dnphaditsapp.data.source.remote.model.PerawiResponse
import kotlinx.coroutines.flow.Flow

interface HaditsRepository {

    suspend fun getPerawi(): PerawiResponse

    fun getHaditsList(
        perawiSlug: String,
        perawiName: (String) -> Unit,
        limit: Int = 20,
    ): Flow<PagingData<HadistResponse>>

    suspend fun getHadits(
        perawi: String,
        nomorHadis: Int
    ):HadistResponse

}