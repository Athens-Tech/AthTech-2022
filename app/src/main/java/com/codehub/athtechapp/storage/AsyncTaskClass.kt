package com.codehub.athtechapp.storage

import android.os.AsyncTask

class AsyncTaskClass : AsyncTask<Void, Void, List<DatabaseEntity>> {
    private val database: DatabaseInstance
    private val listener: AsyncTaskListener

    constructor(database: DatabaseInstance, listener: AsyncTaskListener) : super() {
        this.database = database
        this.listener = listener
    }


    override fun doInBackground(vararg params: Void?): List<DatabaseEntity> {
        return database.getEntityDao().retrieve()
    }

    override fun onPostExecute(result: List<DatabaseEntity>) {
        super.onPostExecute(result)
        listener.onSuccess(result)
    }

}