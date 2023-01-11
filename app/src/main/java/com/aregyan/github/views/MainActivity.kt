package com.aregyan.github.views

import android.Manifest
import android.content.Intent
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.aregyan.github.R
import com.aregyan.github.databinding.ActivityMainBinding
import com.aregyan.github.views.base.BaseActivity
import com.aregyan.github.views.base.model.BasePermissionModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {






    override fun inflateBiding(): ActivityMainBinding {
      return  ActivityMainBinding.inflate(layoutInflater)
     }



    override fun onActivityResult(resultCode: Int, data: Intent?) {
    }

    override fun initViews() {
        requestPermissions(arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CODE)
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

                tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab) {
                        when (tab.position) {
                            0 -> tabNavigate(R.id.users_list_fragment)
                            1 -> tabNavigate(R.id.auditFragment)
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab) {

                    }
                })


            }
        }


    }

//    override fun initNavController(): NavController {
//       return findNavController(viewBinding.navHostFragmentContainer.id)
//    }
}

