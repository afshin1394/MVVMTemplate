package com.irancell.nwg.ios.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.CallSuper
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status
import com.irancell.nwg.ios.Application
import dagger.hilt.android.AndroidEntryPoint


interface ISMSListener {
    fun onSuccess(message: String?)
    fun onError(Status : Int)
}






abstract class HiltBroadcastReceiver : BroadcastReceiver() {
    @CallSuper
    override fun onReceive(context: Context, intent: Intent) {}
}

@AndroidEntryPoint
class MySMSBroadcastReceiver : HiltBroadcastReceiver() {

    lateinit var  listener : ISMSListener




    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        listener = (context.applicationContext as Application).getSmsListener()
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
            val extras = intent.extras
            val status = extras!![SmsRetriever.EXTRA_STATUS] as Status?
            when (status!!.statusCode) {
                CommonStatusCodes.SUCCESS -> {         // Get SMS message contents
                    var message = extras!![SmsRetriever.EXTRA_SMS_MESSAGE] as String?
                    listener.onSuccess(message)
                }
                else -> listener.onError(status!!.statusCode)
            }
        }

    }
}

