package com.myself.restaurants.room

import androidx.room.Room

class Repository {

    val db = Room.databaseBuilder(
        MainApplication.applicationContext(),
        AppDatabase::class.java, "database-name"
    ).build()

    public fun getDAO(): UserDAO {
        return db.userDao()
    }

}