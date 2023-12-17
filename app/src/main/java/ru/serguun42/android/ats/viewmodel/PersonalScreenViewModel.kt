package ru.serguun42.android.ats.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.serguun42.android.ats.di.ServiceLocator
import ru.serguun42.android.ats.model.PersonalDetails
import ru.serguun42.android.ats.repository.mock.MockRepository
import javax.inject.Inject

@HiltViewModel
class PersonalScreenViewModel @Inject constructor(
    serviceLocator: ServiceLocator
) : ViewModel() {
    private val repository = serviceLocator.repository
    private val _dataState = MutableLiveData<PersonalDetails>()
    val dataState: LiveData<PersonalDetails> get() = _dataState

    init {
        setupPersonalDetails()
    }

    private fun setupPersonalDetails() {
        viewModelScope.launch {
            try {
                var gotValue = repository.getPersonalDetails().value
                Log.i("ViewModel", "GOT VALUE IS NULL" + if (gotValue == null) "YES" else "NO")
                if (gotValue == null) {
                    gotValue = MockRepository().personalDetails
                    repository.updatePersonalDetails(gotValue)
                }
                _dataState.value = gotValue
            } catch (e: Exception) {
                Log.e("ViewModel", "Error while setting up", e)
                _dataState.value = MockRepository().personalDetails
            }
        }
    }

    fun savePersonalDetails(personalDetails: PersonalDetails?) {
        if (personalDetails != null) repository.updatePersonalDetails(personalDetails)
    }
}