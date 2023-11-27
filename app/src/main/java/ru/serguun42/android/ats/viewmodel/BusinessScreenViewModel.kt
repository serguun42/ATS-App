package ru.serguun42.android.ats.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.serguun42.android.ats.di.ServiceLocator
import ru.serguun42.android.ats.model.BusinessDetails

class BusinessScreenViewModel : ViewModel() {
    private val repository = ServiceLocator.getInstance().repository
    private val _dataState = MutableLiveData<List<BusinessDetails>>()
    val dataState: LiveData<List<BusinessDetails>> get() = _dataState

    init {
        setupBusinessDetails()
    }

    private fun setupBusinessDetails() {
        viewModelScope.launch {
            try {
                _dataState.value = repository.getAllBusinessDetails().value
            } catch (e: Exception) {
                Log.e("ViewModel", "Error while setting up", e)
            }
        }
    }
}