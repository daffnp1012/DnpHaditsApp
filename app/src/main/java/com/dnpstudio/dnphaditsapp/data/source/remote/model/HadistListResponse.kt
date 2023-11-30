package com.dnpstudio.dnphaditsapp.data.source.remote.model


import com.google.gson.annotations.SerializedName

data class HadistListResponse(
    @SerializedName("items")
    val items: List<HadistResponse>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("total")
    val total: Int
)