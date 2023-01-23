package com.irancell.nwg.ios.domain.attribute

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(

    var Image: String?,

    var options: List<Option>?,

    var comment: String?
) : Parcelable {
    override fun toString(): String {
        return "Data(Image='$Image', options=$options, comment='$comment')"
    }
}
