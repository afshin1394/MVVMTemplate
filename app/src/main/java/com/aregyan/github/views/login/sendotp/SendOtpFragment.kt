package com.aregyan.github.views.login.sendotp

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.aregyan.github.R
import com.aregyan.github.databinding.FragmentSendOtpBinding
//import com.aregyan.github.util.addDividerToPhoneNumber
import com.aregyan.github.views.base.BaseFragment


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


}

