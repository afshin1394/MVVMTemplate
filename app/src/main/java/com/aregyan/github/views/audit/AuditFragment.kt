package com.aregyan.github.views.audit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.aregyan.github.R
import com.aregyan.github.databinding.FragmentAuditBinding
import com.aregyan.github.databinding.FragmentUserDetailsBinding
import com.aregyan.github.views.base.BaseFragment
import com.aregyan.github.views.userDetails.UserDetailsViewModel
import com.aregyan.github.views.userList.UsersListAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


@AndroidEntryPoint
class AuditFragment : BaseFragment<FragmentAuditBinding>() {
    private val viewModel: AuditViewModel by viewModels()

    @Inject
    lateinit var adapter: AuditAdapter




    override fun inflateBiding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): FragmentAuditBinding {
        return FragmentAuditBinding.inflate(layoutInflater,container,false)
    }

    override fun initView() {
        viewBinding.rvAudits.adapter = adapter
        viewModel.refreshUserDetails().observe(viewLifecycleOwner) {
           adapter.submitList(it)
           Timber.i("initView: " + adapter.itemCount)
       }

    }
}