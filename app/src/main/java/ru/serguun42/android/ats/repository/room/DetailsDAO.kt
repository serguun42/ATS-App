package ru.serguun42.android.ats.repository.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import java.util.UUID

@Dao
interface DetailsDAO {
    @Query("SELECT * FROM business_detail")
    fun getAllBusinessDetails(): LiveData<List<BusinessDetails>>

    @Query("SELECT * FROM business_detail SKIP LIMIT 10 OFFSET :skip")
    fun listBusinessDetails(skip: Int): LiveData<List<BusinessDetails>>

    @Query("SELECT * FROM business_detail WHERE id = :id")
    fun getBusinessDetailsById(id: UUID): LiveData<BusinessDetails>

    @Upsert
    fun upsertBusinessDetails(businessDetails: BusinessDetails)

    @Delete
    fun deleteBusinessDetails(businessDetails: BusinessDetails)

    @Query("SELECT * FROM personal_detail LIMIT 1")
    fun getPersonalDetails(): LiveData<PersonalDetails>

    @Upsert
    fun upsertPersonalDetails(personalDetails: PersonalDetails)
}