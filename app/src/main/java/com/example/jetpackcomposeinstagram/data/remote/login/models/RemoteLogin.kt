package com.example.jetpackcomposeinstagram.data.remote.login.models

import com.example.jetpackcomposeinstagram.data.remote.login.models.Constants.PASSWORD
import com.example.jetpackcomposeinstagram.data.remote.login.models.Constants.SUCCESS
import com.example.jetpackcomposeinstagram.data.remote.login.models.Constants.USER
import com.google.gson.annotations.SerializedName

data class RemoteLogin(
    @SerializedName(SUCCESS) val success: Boolean,
    @SerializedName(USER) val user: String,
    @SerializedName(PASSWORD) val password: String
)