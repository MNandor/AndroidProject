package com.myself.restaurants.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "pic") val pic: String?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "addresscityonly") val addressCityOnly: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "loggedin") val loggedin: Boolean
)
