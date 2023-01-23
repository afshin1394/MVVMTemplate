package com.irancell.nwg.ios.views.login

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.databinding.ActivityLoginBinding
import com.irancell.nwg.ios.views.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginActivityViewModel>() {
    override fun inflateBiding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }



    override fun initViews() {

    }

    override fun initViewModel(): LoginActivityViewModel {
        return LoginActivityViewModel();
    }

    override fun initNavController(): NavController {
       return findNavController(R.id.nav_host_login)
    }

}