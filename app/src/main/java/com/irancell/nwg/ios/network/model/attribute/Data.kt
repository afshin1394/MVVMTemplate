package com.irancell.nwg.ios.network.model.attribute

import com.irancell.nwg.ios.base.BaseDataClass
import com.google.gson.annotations.Expose
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Expose
    @Json
    var Image: String?,
    @Expose
    @Json
    var options: List<Option>?,
    @Expose
    @Json
    var comment: String?
) : BaseDataClass(){
    override fun toString(): String {
        return "Data(Image='$Image', options=$options, comment='$comment')"
    }
}
