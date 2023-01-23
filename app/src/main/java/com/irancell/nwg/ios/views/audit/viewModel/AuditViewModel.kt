package com.irancell.nwg.ios.views.audit.viewModel


import android.graphics.Bitmap
import androidx.lifecycle.*
import com.irancell.nwg.ios.database.entity.DatabaseAttributes
import com.irancell.nwg.ios.database.entity.DatabaseAuditDetails
import com.irancell.nwg.ios.domain.AuditDetails
import com.irancell.nwg.ios.domain.attribute.*
import com.irancell.nwg.ios.repository.AttributeRepository
import com.irancell.nwg.ios.repository.AuditRepository


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AuditViewModel @Inject constructor(
    private val auditRepository: AuditRepository,
    private val attributeRepository: AttributeRepository,
) : ViewModel() {


    fun updateImage(id: Int, bitmap: Bitmap) {
        viewModelScope.launch {
            auditRepository.updateImage(id, bitmap)
        }

    }

    fun insertAttribute(siteId: Int, json: String) {
        viewModelScope.launch {
            attributeRepository.insertAttribute(
                databaseAttributes = DatabaseAttributes(
                    1,
                    siteId,
                    json
                )
            )
        }
    }


    fun insertAudit(auditDetails: AuditDetails) {
        viewModelScope.launch {
            auditRepository.insertAudit(
                DatabaseAuditDetails(
                    auditDetails.id,
                    auditDetails.description,
                    auditDetails.image
                )
            )

        }

    }

    fun refreshUserDetails(): LiveData<List<AuditDetails>> {
        insertAudit(auditDetails = AuditDetails(1, "سکتور1", byteArrayOf()))
        insertAudit(AuditDetails(2, "سکتور2", byteArrayOf()))
        insertAudit(AuditDetails(3, "سکتور3", byteArrayOf()))
        insertAudit(AuditDetails(4, "سکتور4", byteArrayOf()))
        insertAudit(AuditDetails(5, "سکتور5", byteArrayOf()))
        insertAudit(AuditDetails(6, "سکتور6", byteArrayOf()))
        insertAudit(AuditDetails(7, "سکتور7", byteArrayOf()))

        return runBlocking {
            auditRepository.getAudits()
        }

    }

    lateinit var attribute: Attribute

    fun getAttributes(site: Int) {
        attribute = attributeRepository.getSiteAttributes(site)
    }

    fun getGroups(): LiveData<List<Group>> {
        return MutableLiveData(attribute.group)
    }

    fun getSubGroups(groupId: Int): LiveData<List<SubGroup>> {
        return MutableLiveData(attribute.group.get(groupId).subGroups)
    }

    fun getElements(groupId: Int, subGroupId: Int): LiveData<List<AttrElement>> {
        return MutableLiveData(attribute.group.get(groupId).subGroups.get(subGroupId).element)
    }

    fun getData(groupId: Int, subGroupId: Int, elementId: Int): LiveData<List<Data>> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).data
        )
    }


    fun getTypeId(groupId: Int, subGroupId: Int, elementId: Int): LiveData<Int> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).type
        )
    }

    fun getTypeName(groupId: Int, subGroupId: Int, elementId: Int): LiveData<String> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).typeName
        )
    }

    fun getOptions(
        groupId: Int,
        subGroupId: Int,
        elementId: Int,
        dataId: Int
    ): LiveData<List<Option>> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).data.get(dataId).options
        )
    }

    fun getComment(groupId: Int, subGroupId: Int, elementId: Int, dataId: Int): LiveData<String> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).data.get(dataId).comment
        )
    }

    fun getImage(groupId: Int, subGroupId: Int, elementId: Int, dataId: Int): LiveData<String> {
        return MutableLiveData(
            attribute.group.get(groupId).subGroups.get(subGroupId).element.get(
                elementId
            ).data.get(dataId).Image
        )
    }

}

