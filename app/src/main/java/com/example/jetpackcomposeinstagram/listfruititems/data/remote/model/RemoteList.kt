package com.example.jetpackcomposeinstagram.listfruititems.data.remote.model

import com.example.jetpackcomposeinstagram.listfruititems.data.remote.model.Constants.LISTAFRUTAS
import com.google.gson.annotations.SerializedName

data class RemoteList(
    @SerializedName(LISTAFRUTAS) val listfruit: List<RemoteListFruit?>?
)