package com.irancell.nwg.ios.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.database.entity.asDomainModel
import com.irancell.nwg.ios.domain.UserListItem
import com.irancell.nwg.ios.network.UserListService
import com.irancell.nwg.ios.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val userListService: UserListService,
    private val database: DataBase
) {

    val users: LiveData<List<UserListItem>> =
        Transformations.map(database.usersDao.getDatabaseUsers()) {
            it.asDomainModel()
        }

    suspend fun refreshUserList() {
        try {
            val users = userListService.getUserList()
            database.usersDao.insertAll(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}