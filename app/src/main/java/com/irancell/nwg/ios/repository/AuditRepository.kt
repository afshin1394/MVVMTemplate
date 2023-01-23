package com.irancell.nwg.ios.repository

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.database.entity.DatabaseAuditDetails
import com.irancell.nwg.ios.database.entity.asDomainModel
import com.irancell.nwg.ios.domain.AuditDetails
import com.irancell.nwg.ios.util.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuditRepository @Inject constructor(
//    private val auditService: AuditService,
    private val database: DataBase
) {
    suspend fun insertAudit(auditDetails: DatabaseAuditDetails) {
        withContext(Dispatchers.IO) {
            database.auditDao.insertAudit(auditDetails)
        }
    }

    suspend fun updateImage(id: Int, bitmap: Bitmap) {
        withContext(Dispatchers.IO) {
            database.auditDao.updateImage(id, bitmap.toByteArray())
        }
    }

      suspend fun getAudits(): LiveData<List<AuditDetails>> {

             return withContext(Dispatchers.IO) {
                 database.auditDao.getAudits().let {
                     Transformations.map(it) {
                         it.asDomainModel()
                     }
                 }
             }

    }


}