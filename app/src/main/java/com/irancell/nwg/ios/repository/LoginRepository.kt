package com.irancell.nwg.ios.repository

import com.google.android.gms.auth.api.phone.SmsRetrieverClient
import com.google.android.gms.tasks.Task
import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val smsRetrieverClient: SmsRetrieverClient,
    private val loginService: LoginService,
    private val database: DataBase
) {

    fun startSmsRetriever() : Task<Void>{
         var task = smsRetrieverClient.startSmsRetriever()
         return task
    }






}