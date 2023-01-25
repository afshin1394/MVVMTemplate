package com.irancell.nwg.ios.views.login.sendotp

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.provider.Telephony
import android.view.LayoutInflater
import android.view.ViewGroup
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.base.BasePermissionModel
import com.irancell.nwg.ios.databinding.FragmentSendOtpBinding
import com.irancell.nwg.ios.receiver.MySMSBroadcastReceiver
import com.irancell.nwg.ios.views.base.BaseFragment


class SendOtpFragment : BaseFragment<FragmentSendOtpBinding>() {
     var smsBroadcastReceiver: MySMSBroadcastReceiver = MySMSBroadcastReceiver()
    override fun inflateBiding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): FragmentSendOtpBinding {
        return FragmentSendOtpBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        checkPermissions(arrayOf(Manifest.permission.RECEIVE_SMS))

    }


    override fun onActivityResult(resultCode: Int, data: Intent?, bundle: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {
        super.onPermission(basePermissionModels)
        val filter = IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
        requireActivity().registerReceiver(smsBroadcastReceiver, filter)
        viewBinding?.linSendOtp?.setOnClickListener {
            navigate(R.id.verifyOtpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}

