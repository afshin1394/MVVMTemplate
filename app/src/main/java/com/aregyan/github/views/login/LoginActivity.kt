package com.aregyan.github.views.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aregyan.github.databinding.ActivityLoginBinding
import com.aregyan.github.views.base.BaseActivity
import com.aregyan.github.views.base.model.BasePermissionModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun inflateBiding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {
    }

    override fun onActivityResult(resultCode: Int, data: Intent?) {
    }

    override fun initViews() {

    }

}