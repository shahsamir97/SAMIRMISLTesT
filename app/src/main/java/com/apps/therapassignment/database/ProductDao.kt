package com.apps.therapassignment.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ProductDao {
    @Insert
    fun insertAll(vararg users: RepoDatabaseModel)
}