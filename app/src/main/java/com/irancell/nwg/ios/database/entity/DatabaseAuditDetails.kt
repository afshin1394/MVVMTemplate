package com.irancell.nwg.ios.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.irancell.nwg.ios.domain.AuditDetails

@Entity
data class DatabaseAuditDetails constructor(
    @PrimaryKey
    val id: Int,
    val description: String,
    val image: ByteArray,
)


fun DatabaseAuditDetails.asDomainModel(): AuditDetails {
    return AuditDetails(
        id = id,
        description = description,
        image = image
    )
}

fun List<DatabaseAuditDetails>.asDomainModel(): List<AuditDetails> {
    return map {
        AuditDetails(
            id = it.id, description = it.description, image = it.image
        )
    }
}
