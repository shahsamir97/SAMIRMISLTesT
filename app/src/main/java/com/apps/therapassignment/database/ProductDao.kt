package com.apps.therapassignment.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<ProductDatabaseModel>)

    @Query("SELECT * FROM ProductDatabaseModel LIMIT :limit OFFSET :offset")
    fun getUsers(limit: Int, offset: Int): List<ProductDatabaseModel>
}
