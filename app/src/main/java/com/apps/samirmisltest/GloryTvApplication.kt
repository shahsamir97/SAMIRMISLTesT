package com.apps.samirmisltest

import android.app.Application
import com.apps.samirmisltest.database.DatabaseHelper
import com.apps.samirmisltest.database.ProductDatabase

class GloryTvApplication: Application() {

     val db:ProductDatabase by lazy { DatabaseHelper.getDatabase(applicationContext) }
}
