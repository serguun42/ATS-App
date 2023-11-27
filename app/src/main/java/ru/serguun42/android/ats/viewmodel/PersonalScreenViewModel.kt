package ru.serguun42.android.ats.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.serguun42.android.ats.di.ServiceLocator
import ru.serguun42.android.ats.model.PersonalDetails

class PersonalScreenViewModel : ViewModel() {
    private val repository = ServiceLocator.getInstance().repository
    private val _dataState = MutableLiveData<PersonalDetails>()
    val dataState: LiveData<PersonalDetails> get() = _dataState

    init {
        setupPersonalDetails()
    }

    private fun setupPersonalDetails() {
        viewModelScope.launch {
            try {
                _dataState.value = repository.getPersonalDetails().value
            } catch (e: Exception) {
                Log.e("ViewModel", "Error while setting up", e)
            }
        }
    }
}