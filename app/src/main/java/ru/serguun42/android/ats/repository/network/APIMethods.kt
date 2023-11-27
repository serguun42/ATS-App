package ru.serguun42.android.ats.repository.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails
import java.util.UUID

interface APIMethods {
    @GET("business/list-all")
    fun getAllBusinessDetails(): Call<List<BusinessDetails>>

    @GET("business/list")
    fun listBusinessDetails(@Query("skip") skip: Int): Call<List<BusinessDetails>>

    @POST("business/create")
    fun upsertBusinessDetails(@Body body: BusinessDetails): Call<BusinessDetails>

    @POST("business/delete")
    fun deleteBusinessDetails(@Body body: BusinessDetails): Call<Boolean>

    @GET("business/get")
    fun getBusinessDetails(@Query("id") id: UUID): Call<BusinessDetails?>

    @POST("personal/get")
    fun getPersonalDetails(): Call<PersonalDetails>

    @POST("personal/update")
    fun updatePersonalDetails(@Body body: PersonalDetails): Call<PersonalDetails>

    companion object {
        const val API_BASE_URL = "https://ats.serguun42.ru/api/v1/"
    }
}