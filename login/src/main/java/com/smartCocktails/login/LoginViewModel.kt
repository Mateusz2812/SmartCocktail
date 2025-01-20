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

    private val redirectEventStateFlow = MutableSharedFlow<RedirectEvent?>()
    val event = redirectEventStateFlow.asSharedFlow()

    fun onProcessAction(event: com.smartCocktails.login.model.LoginActionModel) {
        when (event) {
            is com.smartCocktails.login.model.LoginActionModel.IDChanged ->
                loginStateFlow.update { it.copy(id = event.id) }

            is com.smartCocktails.login.model.LoginActionModel.PasswordChanged ->
                loginStateFlow.update { it.copy(password = event.password) }

            com.smartCocktails.login.model.LoginActionModel.HowToClick -> {}

            com.smartCocktails.login.model.LoginActionModel.LogInClick -> { navigateToHome(
                RedirectEvent.NavigateToHome
            ) }
        }

    }

    private fun navigateToHome(
        event: RedirectEvent
    ) {
        viewModelScope.launch {
            redirectEventStateFlow.emit(event)
        }
    }
}

sealed class RedirectEvent {
    data object NavigateToHome : RedirectEvent()
}