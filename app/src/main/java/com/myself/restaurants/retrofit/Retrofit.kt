package com.myself.restaurants.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    val retrofit = Retrofit.Builder().baseUrl("https://ratpark-api.imok.space/").addConverterFactory(
        GsonConverterFactory.create()).build()

    val apiservice = retrofit.create(API::class.java)


    fun getCities(): Call<CitiesResult?>{
        return apiservice.listCities()
    }

    fun getRestaurants(varos: String="Dallas"): Call<RestaurantsResult> {
        return apiservice.listRestaurants(varos)
    }
}