package com.myself.restaurants.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserFavorite(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "userid") val userid: Int,
    @ColumnInfo(name = "restaurantid") val restaurantid: Int
)
