package com.irancell.nwg.ios.views.audit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irancell.nwg.ios.databinding.AttrCommentItemviewBinding
import com.irancell.nwg.ios.databinding.AttrImageItemviewBinding

import com.irancell.nwg.ios.domain.attribute.AttrElement
import com.irancell.nwg.ios.util.*

import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

class AttrElementAdapter( var elements: List<AttrElement>, val clickListener: ClickListener<AttrElement>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private fun getItemAt(position: Int) : AttrElement{
      return elements[position]
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            Image -> {
              return ViewHolderImage( AttrImageItemviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
              )
            }
            Comment -> {
                return ViewHolderComment( AttrCommentItemviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                )
            }
//            MultiChoice -> {
//                return ViewHolderImage( AttrImageItemviewBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//                )
//            }
//            SingleChoice -> {
//                return ViewHolderImage( AttrImageItemviewBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//                )
//            }
            else -> {
                return ViewHolderImage( AttrImageItemviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            Image -> {
                (holder as ViewHolderImage).bind(getItemAt(position))
            }
            Comment -> {
                (holder as ViewHolderComment).bind(getItemAt(position))
            }
            MultiChoice -> {}
            SingleChoice -> {}
        }
    }


    class ViewHolderImage constructor(private val binding: AttrImageItemviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AttrElement) {
            binding.data = item
            binding.executePendingBindings()
        }


    }

    class ViewHolderComment constructor(private val binding: AttrCommentItemviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AttrElement) {
            binding.data = item
            binding.executePendingBindings()
        }


    }

    override fun getItemViewType(position: Int): Int {
        return getItemAt(position).type
    }

    override fun getItemCount(): Int {
        return elements.size
    }





}
