package com.irancell.nwg.ios.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.irancell.nwg.ios.database.entity.DatabaseAuditDetails

@Dao
interface AuditDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAudit(auditDetails: DatabaseAuditDetails)

    @Query("select * from DatabaseAuditDetails")
    fun getAudits(): LiveData<List<DatabaseAuditDetails>>

    @Query("UPDATE DatabaseAuditDetails SET image = :byteArray WHERE id = :id")
    fun updateImage(id : Int ,byteArray: ByteArray) : Int

}