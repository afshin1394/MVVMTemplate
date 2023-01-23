package com.irancell.nwg.ios.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.irancell.nwg.ios.database.entity.DatabaseUserDetails
import com.irancell.nwg.ios.database.entity.DatabaseUserListItem

@Dao
interface UserDao {
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