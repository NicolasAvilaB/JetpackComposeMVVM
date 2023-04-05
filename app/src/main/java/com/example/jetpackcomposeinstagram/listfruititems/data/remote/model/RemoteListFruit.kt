package com.example.jetpackcomposeinstagram.listfruititems.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteListFruit(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("color") var color: String?,
    @SerializedName("size") var size: String?
)