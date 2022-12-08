package com.apps.therapassignment.database

import androidx.room.RoomDatabase

abstract class ProductDatabase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao

}