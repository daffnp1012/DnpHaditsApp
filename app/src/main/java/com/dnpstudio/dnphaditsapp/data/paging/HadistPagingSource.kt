package com.dnpstudio.dnphaditsapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dnpstudio.dnphaditsapp.data.source.remote.HaditsAPI
import com.dnpstudio.dnphaditsapp.data.source.remote.model.HadistResponse

class HadistPagingSource(
    private val apiService: HaditsAPI,
    private val perawiSlugName: String
): PagingSource<Int, HadistResponse>(){
    override fun getRefreshKey(state: PagingState<Int, HadistResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.prevKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HadistResponse> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getHaditsList(
                perawiSlugName,
                page = page
            )
            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.items.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}