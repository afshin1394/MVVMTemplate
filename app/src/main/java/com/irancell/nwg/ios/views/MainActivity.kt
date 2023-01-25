package com.irancell.nwg.ios.views

import android.Manifest
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.findNavController

import com.google.android.material.tabs.TabLayout
import com.irancell.nwg.ios.R
import com.irancell.nwg.ios.base.BasePermissionModel
import com.irancell.nwg.ios.databinding.ActivityMainBinding
import com.irancell.nwg.ios.views.audit.activity.AuditActivity
import com.irancell.nwg.ios.views.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {






    override fun inflateBiding(): ActivityMainBinding {
      return  ActivityMainBinding.inflate(layoutInflater)
     }




    override fun initViews() {
        checkPermissions(arrayOf(Manifest.permission.CAMERA))
    }

    override fun onPermission(basePermissionModels: ArrayList<BasePermissionModel>) {
        basePermissionModels.any {

            !it.granted
        }.let {
            if (!it) {


                Timber.i("in")
//                binding = ActivityMainBinding.inflate(layoutInflater)
//                val view = binding.root
//                setContentView(view)
                val tabLayout: TabLayout = viewBinding.tabLayout


                tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab) {
                        when (tab.position) {
                            0 -> tabNavigate(R.id.users_list_fragment)
                            1 ->   startActivity(Intent(this@MainActivity, AuditActivity::class.java))

                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab) {

                    }
                })


            }else{
                checkPermissions(arrayOf(Manifest.permission.CAMERA))
            }
        }


    }

    override fun initViewModel(): MainActivityViewModel {
        return MainActivityViewModel()
    }

    override fun initNavController(): NavController {
       return  findNavController(viewBinding.navHostMain.id)
    }

//    override fun initNavController(): NavController {
//       return findNavController(viewBinding.navHostFragmentContainer.id)
//    }
}

