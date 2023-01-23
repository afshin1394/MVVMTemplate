package com.irancell.nwg.ios.network.model.attribute

import com.irancell.nwg.ios.base.BaseDataClass
import com.google.gson.annotations.Expose
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SubGroup(
    @Expose
    @Json(name = "SubGroupId")
    var subGroupId: Int,
    @Expose
    @Json(name = "SubGroupName")
    var subGroupName : String,
    @Expose
    @Json(name = "AttrElements")
    var element: List<AttrElement>
    ): BaseDataClass(){


    override fun toString(): String {
        return "SubGroup(subGroupId=$subGroupId, subGroupName='$subGroupName', element=$element)"
    }
}
