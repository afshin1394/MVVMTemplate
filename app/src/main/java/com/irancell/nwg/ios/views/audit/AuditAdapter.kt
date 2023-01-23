package com.irancell.nwg.ios.views.audit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irancell.nwg.ios.databinding.AuditItemviewBinding
import com.irancell.nwg.ios.domain.AuditDetails
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject


@FragmentScoped
class AuditAdapter@Inject constructor(val clickListener: ClickListener) :
    ListAdapter<AuditDetails, AuditAdapter.ViewHolder>(AuditDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AuditItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }



     class ViewHolder  constructor(private val binding: AuditItemviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AuditDetails, clickListener: ClickListener?) {
            binding.data = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }


    }

}


class AuditDiffCallback : DiffUtil.ItemCallback<AuditDetails>() {

    override fun areItemsTheSame(oldItem: AuditDetails, newItem: AuditDetails): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AuditDetails, newItem: AuditDetails): Boolean {
        return oldItem == newItem
    }

}
 class ClickListener @Inject constructor()
{
    var onCameraClick: ((AuditDetails) -> Unit)? = null
    var onImageClick: ((AuditDetails) -> Unit)? = null

    fun onCameraClick(data: AuditDetails) {
        onCameraClick?.invoke(data)
    }
    fun onImageClick(data: AuditDetails) {
        onImageClick?.invoke(data)
    }
}