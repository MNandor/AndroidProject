package com.myself.restaurants.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface API {

    @GET("cities")
    fun listCities(): Call<CitiesResult?>

    @GET("restaurants")
    fun listRestaurants(@Query("city") varos: String="Dallas"): Call<RestaurantsResult>
}