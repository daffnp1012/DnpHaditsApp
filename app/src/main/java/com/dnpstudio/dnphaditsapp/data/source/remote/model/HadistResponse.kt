package com.dnpstudio.dnphaditsapp.data.source.remote.model


import com.google.gson.annotations.SerializedName

data class HadistResponse(
    @SerializedName("arab")
    val arab: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("slug")
    val slug: String
)