package com.codehub.athtechapp.storage

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.codehub.athtechapp.R

class StorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val database =
            Room.databaseBuilder(this, DatabaseInstance::class.java, "db_AthTech").build()

//        database.getEntityDao().save(DatabaseEntity("vassilis", 100))

        AsyncTaskClassInsert(database).execute(DatabaseEntity("markos", 100))

        AsyncTaskClass(database, object : AsyncTaskListener {
            override fun onSuccess(onResult: List<DatabaseEntity>) {
                findViewById<TextView>(R.id.textView).setText(onResult.size)
            }
        }).execute()
    }

    override fun onPostResume() {
        super.onPostResume()

        val preferences = getPreferences(MODE_PRIVATE)
        getSharedPreferences("dev_names", MODE_PRIVATE)
        preferences
            .edit()
            .putString("name", "Vassilis")
            .apply()
//            .commit()

        preferences.getString("name", "Nothing")
    }
}