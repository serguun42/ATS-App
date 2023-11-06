package ru.serguun42.android.ats.repository

import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import ru.serguun42.android.ats.repository.mock.BusinessDetailsMockData
import ru.serguun42.android.ats.repository.mock.PersonalDetailsMockData

class ATSRepository {
    fun getPersonalDetails(): PersonalDetails {
        return PersonalDetailsMockData()
    }

    fun getBusinessDetails(): BusinessDetails {
        return BusinessDetailsMockData()
    }
}