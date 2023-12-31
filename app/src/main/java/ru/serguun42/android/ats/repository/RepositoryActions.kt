package ru.serguun42.android.ats.repository

import androidx.lifecycle.LiveData
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import java.util.UUID

interface RepositoryActions {
    fun getAllBusinessDetails(): LiveData<List<BusinessDetails>>
    fun listBusinessDetails(skip: Int = 0): LiveData<List<BusinessDetails>>
    fun upsertBusinessDetails(businessDetails: BusinessDetails)
    fun deleteBusinessDetails(businessDetails: BusinessDetails)
    fun getBusinessDetails(id: UUID): LiveData<BusinessDetails?>

    fun getPersonalDetails(): LiveData<PersonalDetails>
    fun updatePersonalDetails(personalDetails: PersonalDetails)
}