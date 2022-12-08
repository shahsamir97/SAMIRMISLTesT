package com.apps.therapassignment

import android.app.Application
import com.apps.therapassignment.database.DatabaseHelper
import com.apps.therapassignment.database.ProductDatabase

class GloryTvApplication: Application() {

    lateinit var db:ProductDatabase

    override fun onCreate() {
        super.onCreate()
        db=DatabaseHelper.getDatabase(applicationContext)
    }
}