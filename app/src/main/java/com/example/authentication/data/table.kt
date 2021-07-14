package com.example.authentication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "mpin")
data class table(
    @PrimaryKey(autoGenerate = true)
    var mpin:String
)