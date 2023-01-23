package com.irancell.nwg.ios.views.login.verifyotp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.irancell.nwg.ios.databinding.FragmentVerifyOtpBinding
import com.irancell.nwg.ios.util.VerifyCodeTextWatcher
import com.irancell.nwg.ios.util.VerifyValidCode
import com.irancell.nwg.ios.views.MainActivity
import com.irancell.nwg.ios.views.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VerifyOtpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VerifyOtpFragment : BaseFragment<FragmentVerifyOtpBinding>() , VerifyValidCode{

    override fun inflateBiding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): FragmentVerifyOtpBinding {
        return FragmentVerifyOtpBinding.inflate(layoutInflater,container,false)
    }

    override fun initView() {

        val edit = arrayOf(
            viewBinding.etCode1,
            viewBinding.etCode2,
            viewBinding.etCode3,
            viewBinding.etCode4
        )
        viewBinding.etCode1.requestFocus()

        viewBinding.etCode1.addTextChangedListener(
            VerifyCodeTextWatcher(
                viewBinding.etCode1,
                edit,
                this
            )
        )
        viewBinding.etCode2.addTextChangedListener(
            VerifyCodeTextWatcher(
                viewBinding.etCode2,
                edit,
                this
            )
        )
        viewBinding.etCode3.addTextChangedListener(
            VerifyCodeTextWatcher(
                viewBinding.etCode3,
                edit,
                this
            )
        )
        viewBinding.etCode4.addTextChangedListener(
            VerifyCodeTextWatcher(
                viewBinding.etCode4,
                edit,
                this
            )
        )

    }

    override fun onVerifyValidCode() {
        val codeNumber1 = viewBinding.etCode1.text.toString()
        val codeNumber2 = viewBinding.etCode2.text.toString()
        val codeNumber3 = viewBinding.etCode3.text.toString()
        val codeNumber4 = viewBinding.etCode4.text.toString()

            if (codeNumber1.length +
                codeNumber2.length +
                codeNumber3.length +
                codeNumber4.length == 4
            ) {
                startActivity(Intent(requireActivity(),MainActivity::class.java))

            } else {
                   //onError
            }


    }


    override fun onActivityResult(resultCode: Int, data: Intent?, bundle: Bundle) {

    }


}