package com.irancell.nwg.ios.database

import androidx.room.*
import com.irancell.nwg.ios.database.dao.AttributeDao
import com.irancell.nwg.ios.database.dao.AuditDao
import com.irancell.nwg.ios.database.dao.UserDao
import com.irancell.nwg.ios.database.entity.DatabaseAttributes
import com.irancell.nwg.ios.database.entity.DatabaseAuditDetails
import com.irancell.nwg.ios.database.entity.DatabaseUserDetails
import com.irancell.nwg.ios.database.entity.DatabaseUserListItem


@Database(entities = [DatabaseUserListItem::class, DatabaseUserDetails::class , DatabaseAuditDetails::class , DatabaseAttributes::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract val usersDao: UserDao
    abstract val auditDao : AuditDao
    abstract val attributeDao : AttributeDao
}