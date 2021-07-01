package com.example.bacaberita.Network

import com.example.bacaberita.Model.ModelBerita
import com.example.bacaberita.Response.ResponseBerita
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/viewed/7.json")
    fun InportBerita(@Query("api-key") apikey: String): Call<List<ResponseBerita>>
}