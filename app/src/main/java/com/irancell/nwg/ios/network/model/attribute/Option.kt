package com.irancell.nwg.ios.network.model.attribute

import com.irancell.nwg.ios.base.BaseDataClass
import com.google.gson.annotations.Expose
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Option(
    @Expose
    @Json
    var key : Int ,
    @Expose
    @Json
    var name : String ,
    @Expose
    @Json
    var value: Int) : BaseDataClass(){
    override fun toString(): String {
        return "Option(key=$key, name='$name', value=$value)"
    }
}

