package com.aregyan.github.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aregyan.github.domain.AuditDetails
import com.aregyan.github.domain.UserDetails
import com.aregyan.github.domain.UserListItem

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
