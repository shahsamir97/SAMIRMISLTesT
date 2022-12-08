package com.apps.therapassignment.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepoDatabaseModel (
    @PrimaryKey val uid: Int,
    val productName: String,
    val productPrice: Int,
    val description: String,
    val imageUrl: String,
)
