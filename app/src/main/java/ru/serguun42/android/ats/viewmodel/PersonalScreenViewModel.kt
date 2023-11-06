package ru.serguun42.android.ats.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.serguun42.android.ats.repository.ATSRepository
import ru.serguun42.android.ats.ui.state.PersonalScreenUIState

public class PersonalScreenViewModel() : ViewModel() {
    private val repository: ATSRepository = ATSRepository()
    public var uiState by mutableStateOf(PersonalScreenUIState(repository.getPersonalDetails()))

    init {
        setupPersonalDetails()
    }

    private fun setupPersonalDetails() {
        viewModelScope.launch {
            try {
                val personalInfo = repository.getPersonalDetails()

                viewModelScope.launch {
                    uiState = PersonalScreenUIState(personalInfo)
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error while setting up", e)
            }
        }
    }
}