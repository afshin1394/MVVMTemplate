package com.irancell.nwg.ios.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.database.entity.asDomainModel
import com.irancell.nwg.ios.domain.UserDetails
import com.irancell.nwg.ios.network.UserDetailsService
import com.irancell.nwg.ios.network.model.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class UserDetailsRepository @Inject constructor(
    private val userDetailsService: UserDetailsService,
    private val database: DataBase
) {

    suspend fun getUserDetails(user: String): LiveData<UserDetails> {
        return withContext(Dispatchers.IO) {
            Transformations.map(database.usersDao.getUserDetails(user)) {
                it?.asDomainModel()
            }
        }
    }


    suspend fun refreshUserDetails(user: String) {
        withContext(Dispatchers.IO) {
            try {
                val userDetails = userDetailsService.getUserDetails(user)
                database.usersDao.insertUserDetails(userDetails.asDatabaseModel())
            } catch (e: Exception) {
                Timber.w(e)
            }
        }
    }

}