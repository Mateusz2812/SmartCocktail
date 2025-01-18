package com.smartCocktails.smartcocktail.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartCocktails.smartcocktail.login.model.LoginActionModel
import com.smartCocktails.smartcocktail.login.model.LoginData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val loginStateFlow = MutableStateFlow(LoginData("", ""))
    val loginState get() = loginStateFlow

    private val redirectEventStateFlow = MutableSharedFlow<RedirectEvent?>()
    val event = redirectEventStateFlow.asSharedFlow()

    fun onProcessAction(event: LoginActionModel) {
        when (event) {
            is LoginActionModel.IDChanged ->
                loginStateFlow.update { it.copy(id = event.id) }

            is LoginActionModel.PasswordChanged ->
                loginStateFlow.update { it.copy(password = event.password) }

            LoginActionModel.HowToClick -> {}

            LoginActionModel.LogInClick -> { navigateToHome(RedirectEvent.NavigateToHome) }
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