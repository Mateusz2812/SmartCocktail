package com.smartCocktails.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val loginStateFlow = MutableStateFlow(com.smartCocktails.login.model.LoginData("", ""))
    val loginState get() = loginStateFlow

    private val loginRedirectEventStateFlow = MutableSharedFlow<LoginRedirectEvent?>()
    val event = loginRedirectEventStateFlow.asSharedFlow()

    fun onProcessAction(event: com.smartCocktails.login.model.LoginActionModel) {
        when (event) {
            is com.smartCocktails.login.model.LoginActionModel.IDChanged ->
                loginStateFlow.update { it.copy(id = event.id) }

            is com.smartCocktails.login.model.LoginActionModel.PasswordChanged ->
                loginStateFlow.update { it.copy(password = event.password) }

            com.smartCocktails.login.model.LoginActionModel.HowToClick -> {}

            com.smartCocktails.login.model.LoginActionModel.LogInClick -> { navigateToHome(
                LoginRedirectEvent.NavigateToHome
            ) }
        }

    }

    private fun navigateToHome(
        event: LoginRedirectEvent
    ) {
        viewModelScope.launch {
            loginRedirectEventStateFlow.emit(event)
        }
    }
}

sealed class LoginRedirectEvent {
    data object NavigateToHome : LoginRedirectEvent()
}