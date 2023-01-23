package com.irancell.nwg.ios.domain.attribute


data class Attribute(
    val siteId: Int,
    val group: List<Group>,
){


    override fun toString(): String {
        return "Attribute(siteId=$siteId, group=$group)"

    }





}


