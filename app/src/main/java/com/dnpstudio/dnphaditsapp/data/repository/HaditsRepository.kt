package com.dnpstudio.dnphaditsapp.data.repository

import com.dnpstudio.dnphaditsapp.data.service.HaditsAPI

class HaditsRepository(private val haditsAPI: HaditsAPI) {
    suspend fun getPerawi() = haditsAPI.getPerawi()
    suspend fun getHadits(perawi: String, page: Int) = haditsAPI.getHadits(perawi, page)
    suspend fun search(perawi: String, nomorHadits: Int) = haditsAPI.search(perawi, nomorHadits)
}