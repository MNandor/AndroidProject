package com.myself.restaurants.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class, UserFavorite::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}
