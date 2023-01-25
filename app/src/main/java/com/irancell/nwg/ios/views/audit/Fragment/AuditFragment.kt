package com.irancell.nwg.ios.views.audit.Fragment

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup


import com.irancell.nwg.ios.databinding.FragmentAuditBinding
import com.irancell.nwg.ios.domain.attribute.Group
import com.irancell.nwg.ios.domain.attribute.SubGroup
import com.irancell.nwg.ios.receiver.MySMSBroadcastReceiver
import com.irancell.nwg.ios.util.ClickListener
import com.irancell.nwg.ios.views.audit.SubGroupAdapter
import com.irancell.nwg.ios.views.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class AuditFragment() : BaseFragment<FragmentAuditBinding>(), ClickListener<SubGroup> {

    @Inject
    lateinit var smsBroadcastReceiver: MySMSBroadcastReceiver
//    private val viewModel: AuditViewModel by viewModels()



    lateinit var adapter: SubGroupAdapter


    override fun inflateBiding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): FragmentAuditBinding {
        return FragmentAuditBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        val group: Group = arguments?.get("groupId") as Group
//        viewBinding.txtGroup.text = group.groupName
        adapter = SubGroupAdapter(group.subGroups,this)
        viewBinding.rvSubGroups.adapter = adapter



//        viewModel.refreshUserDetails().observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//            Timber.i("initView: " + adapter.itemCount)
//        }
//
//        adapter.clickListener.onCameraClick = {
//            var bundle = Bundle()
//            bundle.putInt("id", it.id)
//            startForResultsExtras("android.media.action.IMAGE_CAPTURE", bundle)
//
//        }
//        adapter.clickListener.onImageClick = {
//
//        }

    }

    override fun onActivityResult(resultCode: Int, data: Intent?, bundle: Bundle) {
        var id = bundle.getInt("id")
        val photo = data!!.extras!!["data"] as Bitmap?
        Timber.tag("photoCamera").i("onActivityResult:%s %s", id, photo)

    }

    override fun onClick(t: SubGroup, action: Int) {
        TODO("Not yet implemented")
    }
}