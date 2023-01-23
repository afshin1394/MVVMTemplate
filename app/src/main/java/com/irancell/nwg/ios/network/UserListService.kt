package com.irancell.nwg.ios.network

import com.irancell.nwg.ios.network.model.NetworkUserListItem
import retrofit2.http.GET

interface UserListService {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUserList(): List<NetworkUserListItem>
}