package com.example.jetpackcomposeinstagram.data.listfruititems.remote.model

import com.example.jetpackcomposeinstagram.data.listfruititems.remote.model.Constants.LISTAFRUTAS
import com.google.gson.annotations.SerializedName

data class RemoteList(
    @SerializedName(LISTAFRUTAS) val listfruit: List<RemoteListFruit?>?
)