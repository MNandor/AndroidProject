package com.myself.restaurants.retrofit

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class CitiesResult(
    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("cities")
    @Expose
    val cities: List<String?>

)