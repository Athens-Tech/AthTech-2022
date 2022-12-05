package com.codehub.athtechapp.storage

import androidx.room.*

@Dao
interface EntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data: DatabaseEntity)

    @Insert
    fun insert(data: DatabaseEntity)

    @Delete
    fun delete(data: DatabaseEntity)

    @Update
    fun update(data: DatabaseEntity)

    @Query("SELECT * FROM DatabaseEntity")
    fun retrieve(): List<DatabaseEntity>

    @Query("SELECT * FROM DatabaseEntity LIMIT 1")
    fun retrieve2(): DatabaseEntity

    @Query("SELECT * FROM DatabaseEntity WHERE name LIKE :name LIMIT 1")
    fun retrieve2(name: String): DatabaseEntity

    @Query("SELECT * FROM DatabaseEntity WHERE name LIKE :name")
    fun retrieve3(name: String): List<DatabaseEntity>
}