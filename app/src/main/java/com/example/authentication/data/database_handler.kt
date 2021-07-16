package com.example.authentication.data


import androidx.room.*

@Dao
interface database_handler {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setMpin(input:table)

    @Update
    suspend fun update(input:table)

    @Query("DELETE FROM mpin")
    suspend fun delete()

    @Query("SELECT * FROM mpin")
    suspend fun get() : List<table>

}