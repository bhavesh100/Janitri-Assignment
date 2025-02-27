package com.bhavesh.janitriassignment.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.janitriassignment.data.model.Vitals
import com.bhavesh.janitriassignment.domain.repository.VitalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VitalsViewModel @Inject constructor(private val repository: VitalsRepository) : ViewModel() {

    private val _vitalsList = MutableStateFlow<List<Vitals>>(emptyList())
    val vitalsList: StateFlow<List<Vitals>> = _vitalsList.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allVitals.collectLatest { vitals ->
                _vitalsList.value = vitals
            }
        }
    }

    fun insertVitals(vitals: Vitals) {
        viewModelScope.launch {
            repository.insertVitals(vitals)
        }
    }
}