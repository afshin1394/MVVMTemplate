package com.irancell.nwg.ios.network.model.attribute

import com.irancell.nwg.ios.base.BaseDataClass
import com.google.gson.annotations.Expose
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attribute(
    @Expose
    @Json(name = "siteId") val siteId: Int,
    @Expose
    @Json(name = "Groups") val group: List<Group>,
) : BaseDataClass() {


    override fun toString(): String {
        return "Attribute(siteId=$siteId, group=$group)"

    }





}


