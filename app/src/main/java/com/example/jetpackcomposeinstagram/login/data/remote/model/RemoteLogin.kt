package com.example.jetpackcomposeinstagram.login.data.remote.model

import com.example.jetpackcomposeinstagram.login.data.remote.model.Constants.PASSWORD
import com.example.jetpackcomposeinstagram.login.data.remote.model.Constants.SUCCESS
import com.example.jetpackcomposeinstagram.login.data.remote.model.Constants.USER
import com.google.gson.annotations.SerializedName

data class RemoteLogin(
    @SerializedName(SUCCESS) val success: Boolean,
    @SerializedName(USER) val user: String,
    @SerializedName(PASSWORD) val password: String
)