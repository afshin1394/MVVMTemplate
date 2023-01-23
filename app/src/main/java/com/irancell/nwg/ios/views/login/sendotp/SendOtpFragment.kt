package com.irancell.nwg.ios.views.login.sendotp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.databinding.FragmentSendOtpBinding
import com.irancell.nwg.ios.views.base.BaseFragment


class SendOtpFragment : BaseFragment<FragmentSendOtpBinding>(){
    override fun inflateBiding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): FragmentSendOtpBinding {
       return FragmentSendOtpBinding.inflate(layoutInflater,container,false)
    }

    override fun initView() {
//        viewBinding?.etPhone?.addTextChangedListener(object : TextWatcher {
//            private val space = ' '
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//            override fun afterTextChanged(s: Editable) {
////              addDividerToPhoneNumber(s.toString())
//            }
//        })
        viewBinding?.linSendOtp?.setOnClickListener{
            navigate(R.id.verifyOtpFragment)
        }
    }



    override fun onActivityResult(resultCode: Int, data: Intent?, bundle: Bundle) {
        TODO("Not yet implemented")
    }


}

