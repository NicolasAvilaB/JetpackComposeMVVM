package com.example.jetpackcomposeinstagram.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}