package com.example.smartcocktail.login

import androidx.lifecycle.ViewModel
import com.example.core.internal.InternalNavigator
import com.example.core.internal.RedirectCode
import com.example.smartcocktail.login.model.LoginActionModel
import com.example.smartcocktail.login.model.LoginData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val internalNavigator: InternalNavigator
) : ViewModel() {
    private val loginStateFlow = MutableStateFlow<LoginData>(LoginData("", ""))
    val loginState get() = loginStateFlow.value

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
            LoginActionModel.HowToClick -> {
                internalNavigator.redirect(RedirectCode.HOW_TO_LOGIN)
            }
            LoginActionModel.LogInClick -> {}
        }

    }
}