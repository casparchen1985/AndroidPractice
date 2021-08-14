package com.casparchen.androidpractice

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class AppClientManager private constructor() {
    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient
    private val url: String = "https://gis.taiwan.net.tw/"
    private val logging = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("test", message)
        }
    })
    
    init {
        logging.level = HttpLoggingInterceptor.Level.BASIC
        okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object{
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }

}

interface ApiService{
    @GET("/XMLReleaseALL_public/restaurant_C_f.json")
    fun callPackage(): Call<RowPackage>
}