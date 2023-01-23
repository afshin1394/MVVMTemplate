package com.irancell.nwg.ios.repository

import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.database.entity.DatabaseAttributes
import com.irancell.nwg.ios.domain.attribute.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class AttributeRepository @Inject constructor(
    private val database: DataBase
) {


    suspend fun insertAttribute(databaseAttributes: DatabaseAttributes) {
        withContext(Dispatchers.IO){
            database.attributeDao.insertAttribute(databaseAttributes)
        }
    }

     fun getSiteAttributes(site : Int) : Attribute {
//      var attribute =  withContext(Dispatchers.IO){
//         var json  = mockData()
//          return@withContext Gson().fromJson(json,Attribute::class.java)
//        }
        return mockData()
    }

    fun mockData() : Attribute{
        var data1 = Data("", null, null)

        //Mock Sector Group

        var option1 = Option(1234,"FDD",0)
        var option2 = Option(1235,"TDD",0)
        var InnerInnerData = Data(null, listOf(option1,option2),null)

        var InnerInnerAttrElement = AttrElement(222, "CellType", 3, "MultiSelect", null,listOf(InnerInnerData))

        var InnerInnerSubGroup = SubGroup(333, "CellType", listOf(InnerInnerAttrElement))

        var InnerInnerGroup = Group(33, "SectorAAnttena1", listOf(InnerInnerSubGroup))



        var InnerData = Data(null,null,"1")

        var InnerAttrElement = AttrElement(222, "NumberOfSectorA_Anttena", 2, "generator", listOf(InnerInnerGroup),listOf(InnerData))

        var innerSubGroup = SubGroup(222, "SectorA", listOf(InnerAttrElement))

        var innerGroup = Group(22, "SectorA", listOf(innerSubGroup))



        var Data = Data(null,null,"1")

        var attrElementSct = AttrElement(1, "numberOfSectors", 2, "generator", group = listOf(innerGroup), listOf(Data))

        var subGroupSct = SubGroup(1, "sectors", listOf(attrElementSct))

        var groupSct = Group(2, "Sectors", subGroups = listOf(subGroupSct))

        //Mock Sector Group





        var attElement1 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement2 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement3 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement4 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement5 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement6 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement7 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement8 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement9 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement10 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement11 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement12 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement13 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement14 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement15 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement16 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement17 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement18 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement19 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement20 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement21 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement22 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement23 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement24 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var attElement25 = AttrElement(1, "CR_Open", 1, "Image", null, data = listOf(data1))
        var subGroup = SubGroup(
            1,
            "CR",
            listOf(
                attElement1,
                attElement2,
                attElement3,
                attElement4,
                attElement5,
                attElement16,
                attElement7,
                attElement18,
                attElement19,
                attElement11
            )
        )
        var group = Group(1, "General", listOf(subGroup))
        var attribute =Attribute(1, listOf(group,groupSct))
        var gson = Gson().newBuilder().excludeFieldsWithoutExposeAnnotation().create()
        Timber.tag("JSON").i("onPermission:attribute %s", gson.toJson(attribute))
        return attribute
    }


}