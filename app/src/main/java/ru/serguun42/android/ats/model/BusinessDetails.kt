package ru.serguun42.android.ats.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "business_detail")
class BusinessDetails(
    @PrimaryKey
    var id: UUID,
    var companyName: String,
    var companyLocation: String,
    var jobPosition: String,
    var startDate: String,
    var endDate: String,
    var duties: String
)
