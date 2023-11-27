package ru.serguun42.android.ats.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personal_detail")
class PersonalDetails(
    @PrimaryKey
    var fullname: String,
    var dob: String,
    var locationCity: String,
    var locationCountry: String,
    var jobTitle: String
)