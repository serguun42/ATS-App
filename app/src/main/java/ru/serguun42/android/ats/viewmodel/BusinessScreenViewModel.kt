package ru.serguun42.android.ats.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.serguun42.android.ats.repository.ATSRepository
import ru.serguun42.android.ats.ui.state.BusinessScreenUIState

public class BusinessScreenViewModel() : ViewModel() {
    private val repository: ATSRepository = ATSRepository()
    public var uiState by mutableStateOf(BusinessScreenUIState(repository.getBusinessDetails()))

    init {
        setupBusinessDetails()
    }

    private fun setupBusinessDetails() {
        viewModelScope.launch {
            try {
                val businessInfo = repository.getBusinessDetails()

                viewModelScope.launch {
                    uiState = BusinessScreenUIState(businessInfo)
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error while setting up", e)
            }
        }
    }
}