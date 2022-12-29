package com.example.jetpackcomposeinstagram.data.remote.models

import com.example.jetpackcomposeinstagram.data.remote.models.Constants.PASSWORD
import com.example.jetpackcomposeinstagram.data.remote.models.Constants.SUCCESS
import com.example.jetpackcomposeinstagram.data.remote.models.Constants.USER
import com.google.gson.annotations.SerializedName

data class RemoteLogin(
    @SerializedName(SUCCESS) val success: Boolean,
    @SerializedName(USER) val user: String,
    @SerializedName(PASSWORD) val password: String
)