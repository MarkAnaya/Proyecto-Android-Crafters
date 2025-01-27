package com.example.proyectoandroidcrafters.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroidcrafters.core.SessionRepository
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    private val repository = SessionRepository()
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun createUser(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.registerUser(email, password)
            result?.let { user ->
                Log.i("Session", "SE ha creado el usuario")
            } ?: run {
                Log.e("Error", "No se pudo crear el usuario")
            }
        }
    }
}