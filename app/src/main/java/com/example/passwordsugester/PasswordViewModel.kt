package com.example.passwordsugester

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PasswordViewModel : ViewModel() {

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun generatePassword() {
        viewModelScope.launch {
            val passwordGenerator = PasswordGenerator()
            _password.value = passwordGenerator.getSuggestedPassword(12)
        }
    }
}