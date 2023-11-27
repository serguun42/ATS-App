package ru.serguun42.android.ats.repository.room

import android.app.Application
import androidx.lifecycle.LiveData
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import ru.serguun42.android.ats.repository.RepositoryActions
import java.util.UUID

class RoomRepository(application: Application) : RepositoryActions {
    private val detailsDAO: DetailsDAO

    init {
        val db: RoomDatabase = RoomDatabase.getInstance(application)
        detailsDAO = db.detailsDAO()
    }

    override fun getAllBusinessDetails(): LiveData<List<BusinessDetails>> {
        return detailsDAO.getAllBusinessDetails()
    }

    override fun listBusinessDetails(skip: Int): LiveData<List<BusinessDetails>> {
        return detailsDAO.listBusinessDetails(skip)
    }

    override fun upsertBusinessDetails(businessDetails: BusinessDetails) {
        return detailsDAO.upsertBusinessDetails(businessDetails)
    }

    override fun deleteBusinessDetails(businessDetails: BusinessDetails) {
        return detailsDAO.deleteBusinessDetails(businessDetails)
    }

    override fun getBusinessDetails(id: UUID): LiveData<BusinessDetails?> {
        return detailsDAO.getBusinessDetail(id)
    }

    override fun updatePersonalDetails(personalDetails: PersonalDetails) {
        return detailsDAO.upsertPersonalDetails(personalDetails)
    }

    override fun getPersonalDetails(): LiveData<PersonalDetails> {
        return detailsDAO.getPersonalDetails()
    }
}