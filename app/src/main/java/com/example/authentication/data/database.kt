package com.example.authentication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [table::class],version = 1)
abstract class database: RoomDatabase() {
 abstract fun handler() : database_handler
 companion object{

     @Volatile
     private var instance : database?=null

     @Synchronized
     fun getInstance(context: Context):database{
         if(instance==null) {
             instance= Room.databaseBuilder(context.applicationContext,database::class.java,"database").build()
             return instance as database
         }
         else
         return instance as database
     }
 }
}