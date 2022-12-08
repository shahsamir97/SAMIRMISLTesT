package com.apps.therapassignment.database

import android.content.Context
import androidx.room.Room

object DatabaseHelper {

    fun getDatabase(applicationContext:Context): ProductDatabase {
        return Room.databaseBuilder(
            applicationContext,
            ProductDatabase::class.java, "product-database"
        ).build()
    }
}