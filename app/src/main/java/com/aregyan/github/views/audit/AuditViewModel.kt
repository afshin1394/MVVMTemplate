package com.aregyan.github.views.audit


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aregyan.github.database.DatabaseAuditDetails
import com.aregyan.github.domain.AuditDetails
import com.aregyan.github.repository.AuditRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.Closeable
import javax.inject.Inject

@HiltViewModel
class AuditViewModel @Inject constructor(
    private val auditRepository: AuditRepository
) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            auditRepository.getAudits()
        }
    }

//
    fun insertAudit(auditDetails: AuditDetails) = run {
        viewModelScope.launch(Dispatchers.IO) {
            auditRepository.insertAudit( DatabaseAuditDetails(auditDetails.id,auditDetails.description,auditDetails.image))

        }

    }

     fun refreshUserDetails() : LiveData<List< AuditDetails>> {
            insertAudit(auditDetails = AuditDetails(1,"سکتور1", byteArrayOf()))
            insertAudit(AuditDetails(2,"سکتور2", byteArrayOf()))
            insertAudit(AuditDetails(3,"سکتور3", byteArrayOf()))
            insertAudit(AuditDetails(4,"سکتور4", byteArrayOf()))
            insertAudit(AuditDetails(5,"سکتور5", byteArrayOf()))
            insertAudit(AuditDetails(6,"سکتور6", byteArrayOf()))
            insertAudit(AuditDetails(7,"سکتور7", byteArrayOf()))
           return auditRepository.getAudits()
    }




}

