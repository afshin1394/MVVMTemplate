package com.irancell.nwg.ios.network.model.attribute

import com.irancell.nwg.ios.base.BaseDataClass
import com.google.gson.annotations.Expose
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Group(
    @Expose
    @Json(name = "GroupID")
    var groupId: Int,
    @Expose
    @Json(name = "GroupName")
    var groupName : String,
    @Expose
    @Json(name = "SubGroups")
    var subGroups : List<SubGroup>
): BaseDataClass() {
    override fun toString(): String {
        return "Group(groupId=$groupId, groupName='$groupName', subGroups=$subGroups)"
    }
}

