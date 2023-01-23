package com.irancell.nwg.ios.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.irancell.nwg.ios.database.entity.DatabaseAttributes

@Dao
interface AttributeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAttribute(databaseAttributes: DatabaseAttributes)

    @Query("select json from DatabaseAttributes where siteId = :siteId")
    fun getSiteAttributes(siteId : Int): String

}