package com.irancell.nwg.ios.views.base

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.base.BasePermissionModel


abstract class BaseFragment<V : ViewBinding> : Fragment() {
    val PERMISSION_REQUEST_CODE = 9824

    protected lateinit var viewBinding: V

    protected lateinit var lifecycleOwner : LifecycleOwner
    protected abstract fun inflateBiding(inflater: LayoutInflater?, container: ViewGroup?): V
    protected abstract fun initView()
    abstract fun onActivityResult(resultCode: Int, data: Intent?,bundle: Bundle)

    open fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {

    }

    fun tabNavigate(destination : Int){
        val navController = findNavController()
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
        val navController = findNavController()
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .build()
        navController.navigate(destination, null, navOptions);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = inflateBiding(inflater, container)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    lateinit var bundle : Bundle
    fun startForResultsExtras(action : String,bundle: Bundle)
    {
        val chooserIntent = Intent(action)
        this.bundle = bundle
        startActivityIntent.launch(chooserIntent)
    }

    private var startActivityIntent: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        onActivityResult(it.resultCode,it.data,this.bundle)
    }

    open fun checkPermissions(permissions: Array<String?>) {
        val permissionArray = java.util.ArrayList<BasePermissionModel>()
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
            val permissionResults = java.util.ArrayList<BasePermissionModel>()
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


    override fun onDestroyView() {
        super.onDestroyView()
    }



}