package com.example.jetpackcomposeinstagram.data.remote.models

import com.example.jetpackcomposeinstagram.data.remote.models.Constants.SUCCESS
import com.google.gson.annotations.SerializedName

data class RemoteLogin(@SerializedName(SUCCESS) val success: Boolean)