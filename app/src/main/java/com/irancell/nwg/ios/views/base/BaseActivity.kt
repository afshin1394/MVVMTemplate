package com.irancell.nwg.ios.views.base

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.viewbinding.ViewBinding
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.base.BasePermissionModel


abstract class BaseActivity<V : ViewBinding, VMC : ViewModel> : FragmentActivity() {
    val PERMISSION_REQUEST_CODE = 9824
    lateinit var activity: AppCompatActivity
    lateinit var navController: NavController
    private lateinit var binding: V
    val viewBinding get() = binding
    lateinit var viewModel: VMC
//  abstract fun initActivity(): AppCompatActivity
    abstract fun initNavController(): NavController
    abstract fun inflateBiding(): V
    abstract fun initViewModel() : VMC
    open fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {

    }

    open fun onActivityResult(resultCode: Int, data: Intent?) {

    }

    protected abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBiding()
        viewModel = initViewModel()

        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
        navController = initNavController()


        initViews()
    }

    fun tabNavigate(destination: Int) {
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

    fun navigate(destination: Int) {
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .build()

        navController.navigate(destination, null, navOptions);
    }

    fun navigateWithArg(destination: Int,bundle: Bundle) {

        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .setLaunchSingleTop(true)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()


        navController.navigate(destination,bundle, navOptions);
    }



    open fun checkPermissions(permissions: Array<String?>) {
        val permissionArray: ArrayList<BasePermissionModel> = ArrayList()
        for (permission in permissions) {
            permissionArray.add(BasePermissionModel(permission, true))
        }
        requestPermissions(permissions, PERMISSION_REQUEST_CODE)
        onPermission(permissionArray)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            val permissionResults: ArrayList<BasePermissionModel> = ArrayList()
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

    fun startForResults(action: String) {
        val chooserIntent = Intent(action)
        startActivityIntent.launch(chooserIntent);
    }

    fun startForResultsExtras(action: String, bundle: Bundle) {
        val chooserIntent = Intent(action)
        chooserIntent.extras?.putBundle("bundle", bundle)
        startActivityIntent.launch(chooserIntent);
    }

    var startActivityIntent: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        onActivityResult(it.resultCode, it.data);
    }





}