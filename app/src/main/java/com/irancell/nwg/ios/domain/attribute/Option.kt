
package com.irancell.nwg.ios.domain.attribute

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Option(

    var key : Int ,

    var name : String ,

    var value: Int) : Parcelable

