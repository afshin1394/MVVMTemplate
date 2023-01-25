package com.irancell.nwg.ios

import android.app.Application
import com.irancell.nwg.ios.receiver.ISMSListener
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Application : Application() {

    lateinit var iSMSListener: ISMSListener

    fun setSmsListener(iSMSListener: ISMSListener) {
        this.iSMSListener = iSMSListener
    }

    fun getSmsListener() = iSMSListener

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}