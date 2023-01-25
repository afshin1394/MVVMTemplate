package com.irancell.nwg.ios.views.login

import android.content.IntentFilter
import android.provider.Telephony
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.irancell.nwg.ios.Application
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.base.BasePermissionModel
import com.irancell.nwg.ios.databinding.ActivityLoginBinding
import com.irancell.nwg.ios.receiver.ISMSListener
import com.irancell.nwg.ios.receiver.MySMSBroadcastReceiver
import com.irancell.nwg.ios.views.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity  : BaseActivity<ActivityLoginBinding,LoginActivityViewModel>(), ISMSListener {
        var smsBroadcastReceiver = MySMSBroadcastReceiver()
    override fun inflateBiding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }



    override fun initViews() {
     checkPermissions(arrayOf(android.Manifest.permission.RECEIVE_SMS))
    }

    override fun initViewModel(): LoginActivityViewModel {
        return LoginActivityViewModel();
    }

    override fun initNavController(): NavController {
       return findNavController(R.id.nav_host_login)
    }

    override fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {
        if(!basePermissionModels.any{!it.granted}) {
            val filter = IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
            registerReceiver(smsBroadcastReceiver, filter)
            (application as Application).setSmsListener(this)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSuccess(message: String?) {
    }

    override fun onError(Status: Int) {
    }


}