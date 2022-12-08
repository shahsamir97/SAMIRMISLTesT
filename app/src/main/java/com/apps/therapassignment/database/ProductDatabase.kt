package com.apps.therapassignment.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductDatabaseModel::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao

}