package com.codehub.athtechapp.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DatabaseEntity {
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "age")
    var age: Int = 0
}