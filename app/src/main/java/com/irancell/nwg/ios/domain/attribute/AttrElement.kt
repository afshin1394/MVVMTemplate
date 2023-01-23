package com.irancell.nwg.ios.domain.attribute

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AttrElement(

    var id  : Int,

    var attrElementName : String,

    var type : Int,

    var typeName : String,

    var group: List<Group>?,

    var data : List<Data>
    ) : Parcelable {
    override fun toString(): String {
        return "AttrElement(id=$id, attrElementName='$attrElementName', type=$type, typeName='$typeName', group=$group, data=$data)"
    }
}
