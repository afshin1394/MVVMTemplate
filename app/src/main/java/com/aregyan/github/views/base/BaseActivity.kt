package com.aregyan.github.views.base

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.aregyan.github.R
import com.aregyan.github.views.base.model.BasePermissionModel


abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
    val PERMISSION_REQUEST_CODE = 9824
    lateinit var activity: AppCompatActivity
    lateinit var navController: NavController
    lateinit var viewBinding: V
//    abstract fun initActivity(): AppCompatActivity
//    abstract fun initNavController(): NavController
    abstract fun inflateBiding(): V
    abstract fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>)
    abstract fun onActivityResult(resultCode: Int, data: Intent?)
    protected abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateBiding()
        setContentView(viewBinding.root)
//        navController = initNavController()

        initViews()
//        activity = initActivity()

    }

    fun tabNavigate(destination : Int){
        val navController = findNavController(R.id.nav_host_fragment_container)
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .setLaunchSingleTop(true)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()

        navController.navigate(destination, null, navOptions);
    }

    fun navigate(destination : Int){
        val navController = findNavController(R.id.nav_host_fragment_container)
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .build()

        navController.navigate(destination, null, navOptions);
    }


    open fun checkPermissions(permissions: Array<String?>) {
        val permissionArray: ArrayList<BasePermissionModel> = ArrayList<BasePermissionModel>()
        for (permission in permissions) {
            permissionArray.add(BasePermissionModel(permission, true))
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
        }
        onPermission(permissionArray)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            val permissionResults: ArrayList<BasePermissionModel> = ArrayList<BasePermissionModel>()
            for (i in permissions.indices) {
                permissionResults.add(
                    BasePermissionModel(
                        permissions[i], grantResults[i] == PackageManager.PERMISSION_GRANTED
                    )
                )
            }
            onPermission(permissionResults)
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    fun startForResults(action : String){
        val chooserIntent = Intent(action)
        startActivityIntent.launch(chooserIntent);
    }
    fun startForResultsExtras(action : String,bundle: Bundle)
    {
        val chooserIntent = Intent(action)
        chooserIntent.extras?.putBundle("bundle",bundle)
        startActivityIntent.launch(chooserIntent);
    }

    var startActivityIntent: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        onActivityResult(it.resultCode,it.data);
    }


}