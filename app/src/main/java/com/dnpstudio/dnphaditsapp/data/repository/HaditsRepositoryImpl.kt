package com.dnpstudio.dnphaditsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dnpstudio.dnphaditsapp.data.paging.HadistPagingSource
import com.dnpstudio.dnphaditsapp.data.source.remote.HaditsAPI
import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistResponse
import com.dnpstudio.dnphaditsapp.data.source.remote.model.PerawiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class HaditsRepositoryImpl(
    private val hadithApi: HaditsAPI
): HaditsRepository {

    override suspend fun getPerawi(): PerawiResponse {
        return hadithApi.getPerawi()
    }

    override fun getHaditsList(
        perawiSlug: String,
        perawiName: (String) -> Unit,
        limit: Int
    ): Flow<PagingData<HadistResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                HadistPagingSource(
                    hadithApi,
                    perawiSlug
                )
            }
        ).flow.flowOn(Dispatchers.Default)
    }


    override suspend fun getHadits(perawi: String, nomorHadis: Int): HadistResponse {
        return hadithApi.getHadits(perawi, nomorHadis)
    }

}