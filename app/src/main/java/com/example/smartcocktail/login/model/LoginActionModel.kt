package com.example.smartcocktail.login.model

sealed class LoginActionModel {
    data class IDChanged(val id: String): LoginActionModel()
    data class PasswordChanged(val password: String): LoginActionModel()
    data object LogInClick: LoginActionModel()
    data object HowToClick: LoginActionModel()
}