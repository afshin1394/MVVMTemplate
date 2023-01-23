package com.irancell.nwg.ios.network.model.attribute

import com.google.gson.annotations.Expose
import com.irancell.nwg.ios.base.BaseDataClass
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttrElement(
    @Expose
    @Json(name = "AttrElementId")
    var id  : Int,
    @Expose
    @Json(name = "AttrElementName")
    var attrElementName : String,
    @Expose
    @Json(name = "type")
    var type : Int,
    @Expose
    @Json(name = "typeName")
    var typeName : String,
    @Expose
    @Json(name = "innerGroup")
    var group: List<Group>?,
    @Expose
    @Json(name = "data")
    var data : List<Data>
    ) :  BaseDataClass(){
    override fun toString(): String {
        return "AttrElement(id=$id, attrElementName='$attrElementName', type=$type, typeName='$typeName', group=$group, data=$data)"
    }
}
