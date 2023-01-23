package com.irancell.nwg.ios.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseAttributes constructor(
    @PrimaryKey(autoGenerate = true)
    val attrId: Int
    ,val siteId: Int
    ,val json: String)
