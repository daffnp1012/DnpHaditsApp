package com.dnpstudio.dnphaditsapp.response


import com.google.gson.annotations.SerializedName

data class SearchHadistResponse(
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