package com.codehub.athtechapp.storage

import android.os.AsyncTask

class AsyncTaskClassInsert : AsyncTask<DatabaseEntity, Void, Void> {
    private val database: DatabaseInstance

    constructor(database: DatabaseInstance) : super() {
        this.database = database
    }


    override fun doInBackground(vararg params: DatabaseEntity): Void? {
        params.forEach {
            database.getEntityDao().save(it)
        }
        return null
    }
}