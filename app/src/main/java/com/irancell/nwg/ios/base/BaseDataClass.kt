package com.irancell.nwg.ios.base

import com.google.gson.Gson

abstract class BaseDataClass {
    open fun <T> toJson(t : T) : String {
         return Gson().newBuilder().create().toJson(t)
     }


}