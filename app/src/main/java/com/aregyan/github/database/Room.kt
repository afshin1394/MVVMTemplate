package com.aregyan.github.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aregyan.github.domain.AuditDetails

@Dao
interface UsersDao {

    // user List
    @Query("select * from DatabaseUserListItem")
    fun getDatabaseUsers(): LiveData<List<DatabaseUserListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<DatabaseUserListItem>)

    // single user
    @Query("select * from DatabaseUserDetails WHERE user LIKE :user")
    fun getUserDetails(user: String): LiveData<DatabaseUserDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserDetails(databaseUserDetails: DatabaseUserDetails)
}


@Dao
interface AuditDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAudit(auditDetails: DatabaseAuditDetails)

    @Query("select * from DatabaseAuditDetails")
    fun getAudits(): LiveData<List<DatabaseAuditDetails>>

}

@Database(entities = [DatabaseUserListItem::class, DatabaseUserDetails::class , DatabaseAuditDetails::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract val usersDao: UsersDao
    abstract val auditDao : AuditDao
}