package com.dnpstudio.dnphaditsapp.data.model


import com.google.gson.annotations.SerializedName

data class HadistResponse(
    @SerializedName("items")
    val items: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("total")
    val total: Int
)