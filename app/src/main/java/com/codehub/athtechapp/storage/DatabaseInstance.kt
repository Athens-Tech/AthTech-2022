package com.codehub.athtechapp.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabaseEntity::class], version = 1)
abstract class DatabaseInstance : RoomDatabase() {

    abstract fun getEntityDao(): EntityDao

}