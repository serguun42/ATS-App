package ru.serguun42.android.ats.repository.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import ru.serguun42.android.ats.repository.RepositoryActions
import java.util.UUID


class APIRepository : RepositoryActions {
    private val api: APIMethods

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(APIMethods.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        api = retrofit.create(APIMethods::class.java)
    }

    override fun getAllBusinessDetails(): LiveData<List<BusinessDetails>> {
        val businessDetailsList = MutableLiveData<List<BusinessDetails>>()

        api.getAllBusinessDetails().enqueue(object : Callback<List<BusinessDetails>> {
            override fun onFailure(call: Call<List<BusinessDetails>>, t: Throwable) {
                businessDetailsList.value = emptyList()
            }

            override fun onResponse(
                call: Call<List<BusinessDetails>>,
                response: Response<List<BusinessDetails>>
            ) {
                if (!response.isSuccessful) businessDetailsList.value = emptyList()
                else businessDetailsList.value = response.body()
            }

        })

        return businessDetailsList
    }

    override fun listBusinessDetails(skip: Int): LiveData<List<BusinessDetails>> {
        val businessDetailsList = MutableLiveData<List<BusinessDetails>>()

        api.listBusinessDetails(skip).enqueue(object : Callback<List<BusinessDetails>> {
            override fun onFailure(call: Call<List<BusinessDetails>>, t: Throwable) {
                businessDetailsList.value = emptyList()
            }

            override fun onResponse(
                call: Call<List<BusinessDetails>>,
                response: Response<List<BusinessDetails>>
            ) {
                if (!response.isSuccessful) businessDetailsList.value = emptyList()
                else businessDetailsList.value = response.body()
            }

        })

        return businessDetailsList
    }

    override fun upsertBusinessDetails(businessDetails: BusinessDetails) {
        api.upsertBusinessDetails(businessDetails)
            .enqueue(object : Callback<BusinessDetails> {
                override fun onFailure(call: Call<BusinessDetails>, t: Throwable) {
                    // Show error later
                }

                override fun onResponse(
                    call: Call<BusinessDetails>,
                    response: Response<BusinessDetails>
                ) {
                    // Check for IDS and show error later
                }
            })
    }

    override fun deleteBusinessDetails(businessDetails: BusinessDetails) {
        api.deleteBusinessDetails(businessDetails)
            .enqueue(object : Callback<Boolean> {
                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    // Show error later
                }

                override fun onResponse(
                    call: Call<Boolean>,
                    response: Response<Boolean>
                ) {
                    // Check boolean and show error later
                }
            })
    }

    override fun getBusinessDetails(id: UUID): LiveData<BusinessDetails?> {
        val businessDetails = MutableLiveData<BusinessDetails>()

        api.getBusinessDetails(id).enqueue(object : Callback<BusinessDetails?> {
            override fun onFailure(call: Call<BusinessDetails?>, t: Throwable) {
                businessDetails.value = null
            }

            override fun onResponse(
                call: Call<BusinessDetails?>,
                response: Response<BusinessDetails?>
            ) {
                if (!response.isSuccessful) businessDetails.value = null
                else businessDetails.value = response.body()
            }

        })

        return businessDetails
    }

    override fun getPersonalDetails(): LiveData<PersonalDetails> {
        val personalDetails = MutableLiveData<PersonalDetails>()

        api.getPersonalDetails().enqueue(object : Callback<PersonalDetails> {
            override fun onFailure(call: Call<PersonalDetails>, t: Throwable) {
                personalDetails.value = null
            }

            override fun onResponse(
                call: Call<PersonalDetails>,
                response: Response<PersonalDetails>
            ) {
                if (!response.isSuccessful) personalDetails.value = null
                else personalDetails.value = response.body()
            }

        })

        return personalDetails
    }

    override fun updatePersonalDetails(personalDetails: PersonalDetails) {
        api.updatePersonalDetails(personalDetails)
            .enqueue(object : Callback<PersonalDetails> {
                override fun onFailure(call: Call<PersonalDetails>, t: Throwable) {
                    // Show error later
                }

                override fun onResponse(
                    call: Call<PersonalDetails>,
                    response: Response<PersonalDetails>
                ) {
                    // Check for IDS and show error later
                }
            })
    }
}