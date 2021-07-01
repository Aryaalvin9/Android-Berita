package com.example.bacaberita.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bacaberita.Adapter.AdapterBerita
import com.example.bacaberita.Model.ModelBerita
import com.example.bacaberita.Network.ApiService
import com.example.bacaberita.Network.InitRetrofit
import com.example.bacaberita.R
import com.example.bacaberita.Response.ResponseBerita
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit2 = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit2.create(ApiService::class.java)
        api.InportBerita("8QIx1hFmFwddExnbd9KiOrzZbN5CvsM4")
            .enqueue(object : retrofit2.Callback<List<ResponseBerita>> {
                override fun onResponse(call: Call<List<ResponseBerita>>, response: Response<List<ResponseBerita>>) {
                    Log.d("Network","OnResume: ${response.body()?.get(0)?.status}")
                    //showData(response.body()!!)
                }
                override fun onFailure(call: Call<List<ResponseBerita>>, t: Throwable) {
                    Log.d("Network","OnFileUrl")
                }
            })
    }
    private fun showData(modelBerita: List<ModelBerita>) {
        recyclerView = findViewById(R.id.recycler) as RecyclerView
        recyclerView?.apply { layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AdapterBerita(modelBerita)}
    }
}

