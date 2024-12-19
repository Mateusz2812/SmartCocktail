package com.example.smartcocktail.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcocktail.login.model.LoginActionModel
import com.example.smartcocktail.login.model.LoginData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val loginStateFlow = MutableStateFlow(LoginData("", ""))
    val loginState get() = loginStateFlow
    private val _event = MutableStateFlow<Event?>(null)
    val event = _event.asStateFlow()

    fun onProcessAction(event: LoginActionModel) {
        when (event) {
            is LoginActionModel.IDChanged -> {
                loginStateFlow.update {
                    it.copy(
                        id = event.id
                    )
                }
            }

            is LoginActionModel.PasswordChanged ->
                loginStateFlow.update {
                    it.copy(
                        password = event.password
                    )
                }
            LoginActionModel.HowToClick -> {}

            LoginActionModel.LogInClick -> {
                navigateToHome()
            }
        }

    }

    fun navigateToHome() {
        viewModelScope.launch {
            _event.emit(Event.NavigateToHomeActivity)
        }
    }
}

sealed class Event {
    object NavigateToHomeActivity : Event()
}