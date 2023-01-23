package com.irancell.nwg.ios.views.audit.activity

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.irancell.nwg.ios.databinding.ActivityAuditBinding
import com.irancell.nwg.ios.views.audit.adapter.ViewPagerAdapter
import com.irancell.nwg.ios.views.audit.Fragment.AuditFragment
import com.irancell.nwg.ios.views.audit.viewModel.AuditViewModel
import com.irancell.nwg.ios.views.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class AuditActivity : BaseActivity<ActivityAuditBinding, AuditViewModel>() {


    override fun inflateBiding(): ActivityAuditBinding {
        return ActivityAuditBinding.inflate(layoutInflater)
    }

    override fun initViews() {

        viewModel.getAttributes(1)
        var fragments : ArrayList<Fragment> = ArrayList()
        viewModel.getGroups().observe(this) {
            Timber.tag("Sizeeee").i("initViews: %s", it.size)
            it.iterator().forEach {
                var tab = viewBinding.tabLayout.newTab()
                tab.tag = it.groupName
                tab.id = it.groupId
                tab.text = it.groupName
                Timber.tag("groupNameee").i("initViews: %s", it.groupName)
                viewBinding.tabLayout.addTab(tab)
                var fragment = AuditFragment()
                fragment.arguments = bundleOf(Pair( "group",it))
                fragments.add(fragment)
            }



            viewBinding.viewPager.adapter =
                ViewPagerAdapter(fragments,supportFragmentManager,lifecycle)


            val tabLayout: TabLayout = viewBinding.tabLayout
            TabLayoutMediator(
                tabLayout, viewBinding.viewPager
            ) { tab, position ->
                tab.setText(
                   tab.text
                )
            }.attach()


        }
    }

    override fun initViewModel(): AuditViewModel {
        return ViewModelProvider(this).get(AuditViewModel::class.java)
    }

    override fun initNavController(): NavController {
        return NavController(this)
    }


}