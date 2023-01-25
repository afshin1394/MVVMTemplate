package com.irancell.nwg.ios.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irancell.nwg.ios.domain.attribute.AttrElement
import com.irancell.nwg.ios.views.audit.AttrElementAdapter
import com.irancell.nwg.ios.views.audit.SubGroupAdapter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(url).into(view)
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, image: ByteArray?) {
    if (image?.size!! >0) {
        Glide.with(view.context).load(image).into(view)
    }
}



@BindingAdapter("dateFormatter")
fun TextView.dateFormatter(string: String?) {
    if (string?.isNotEmpty() == true) {
        val date = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(string)
        date?.let {
            val format = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
            this.text = format.format(it)
        }

    }

}