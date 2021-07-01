package com.example.bacaberita.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {
    private lateinit var apiService: ApiService
    fun getApiService(): ApiService{
        if (!::apiService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/viewed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }
       return apiService
    }
}