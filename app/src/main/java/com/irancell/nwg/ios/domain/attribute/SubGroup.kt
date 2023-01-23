package com.irancell.nwg.ios.domain.attribute

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubGroup(

    var subGroupId: Int,

    var subGroupName : String,

    var element: List<AttrElement>
    ) : Parcelable {


    override fun toString(): String {
        return "SubGroup(subGroupId=$subGroupId, subGroupName='$subGroupName', element=$element)"
    }
}
