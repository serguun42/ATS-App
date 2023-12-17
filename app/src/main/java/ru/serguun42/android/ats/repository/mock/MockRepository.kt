package ru.serguun42.android.ats.repository.mock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import ru.serguun42.android.ats.repository.RepositoryActions
import java.util.UUID

class MockRepository : RepositoryActions {
    val businessDetails = listOf(
        BusinessDetails(
            UUID.randomUUID(),
            "Dunder Mifflin Paper Company, Inc",
            "Кемь",
            "Quality Assurance",
            "2005-03-24",
            "2013-05-16",
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Itaque quisquam asperiores accusamus quas repellendus maxime quibusdam nulla, consequatur autem minima, temporibus animi, minus eius? Omnis delectus accusamus quidem repellat autem pariatur doloribus sit fugit, beatae temporibus quo? Nesciunt, voluptates voluptate consequatur facere, beatae eaque atque, fugit facilis sapiente nihil laboriosam officia modi quasi magni eos in. Dicta delectus quam totam sapiente eaque fugiat praesentium atque! Blanditiis, odit culpa eos labore quaerat recusandae ea! Corporis, repellendus. In, recusandae, repudiandae dolor sed modi veniam quos non iure libero rem consequuntur id fuga temporibus blanditiis animi? Odit, amet nesciunt cum aut exercitationem soluta!"
        )
    )

    val personalDetails = PersonalDetails(
        "John Doe", "1990-10-20", "Moscow", "Russia", "Operation Commissioning Supervisor"
    )

    override fun getAllBusinessDetails(): LiveData<List<BusinessDetails>> {
        return MutableLiveData(businessDetails)
    }

    override fun listBusinessDetails(skip: Int): LiveData<List<BusinessDetails>> {
        return MutableLiveData(businessDetails.slice(skip until businessDetails.size - 1))
    }

    override fun deleteBusinessDetails(businessDetails: BusinessDetails) {/* EMPTY */
    }

    override fun upsertBusinessDetails(businessDetails: BusinessDetails) {/* EMPTY */
    }

    override fun getBusinessDetails(id: UUID): LiveData<BusinessDetails?> {
        return MutableLiveData(businessDetails[0])
    }

    override fun getPersonalDetails(): LiveData<PersonalDetails> {
        return MutableLiveData(personalDetails)
    }

    override fun updatePersonalDetails(personalDetails: PersonalDetails) {/* EMPTY */
    }
}