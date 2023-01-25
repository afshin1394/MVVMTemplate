package com.irancell.nwg.ios.views.audit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irancell.nwg.ios.databinding.SubGroupItemviewBinding
import com.irancell.nwg.ios.domain.attribute.AttrElement
import com.irancell.nwg.ios.domain.attribute.SubGroup
import com.irancell.nwg.ios.util.ClickListener
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject


class SubGroupAdapter (var subGroups : List<SubGroup>,var clickListener: ClickListener<SubGroup>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SubGroupItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return subGroups.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(subGroups.get(position))
    }


    class ViewHolder  constructor(private val binding: SubGroupItemviewBinding) :
        RecyclerView.ViewHolder(binding.root), ClickListener<AttrElement> {

        fun bind(item: SubGroup) {

            binding.data = item
            binding.executePendingBindings()
            var adapter = AttrElementAdapter(item.element,this)
            binding.RVElements.adapter = adapter

        }



        override fun onClick(t: AttrElement, action: Int) {

        }


    }




}

