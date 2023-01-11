package com.aregyan.github.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aregyan.github.database.DataBase
import com.aregyan.github.database.DatabaseAuditDetails
import com.aregyan.github.database.asDomainModel
import com.aregyan.github.domain.AuditDetails
import com.aregyan.github.domain.UserDetails
import com.aregyan.github.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class AuditRepository @Inject constructor(
//    private val auditService: AuditService,
    private val database: DataBase
) {
    suspend fun insertAudit(auditDetails: DatabaseAuditDetails) {
        database.auditDao.insertAudit(auditDetails)
    }
    fun getAudits(): LiveData<List<AuditDetails>> {
       var auditDetails = database.auditDao.getAudits();
       return  Transformations.map( auditDetails){
           it.asDomainModel()
       }

    }


}