package com.codehub.athtechapp.storage

interface AsyncTaskListener {

    fun onSuccess(onResult: List<DatabaseEntity>)
}