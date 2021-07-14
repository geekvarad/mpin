package com.example.authentication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface database_handler {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setMpin(mpin:String){

    }

}