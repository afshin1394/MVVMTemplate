package com.irancell.nwg.ios.domain.attribute

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Group(

    var groupId: Int,

    var groupName : String,

    var subGroups : List<SubGroup>
) : Parcelable {
    override fun toString(): String {
        return "Group(groupId=$groupId, groupName='$groupName', subGroups=$subGroups)"
    }
}

