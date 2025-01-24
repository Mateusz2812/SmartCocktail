package com.smartCocktails.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.components.BasicButton
import com.smartCocktails.core.ui.components.BasicEditText
import com.smartCocktails.core.ui.components.EditTextType
import com.smartCocktails.login.LoginViewModel
import com.smartCocktails.login.R
import com.smartCocktails.login.model.LoginActionModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    style: LoginScreenStyle = loginScreenStyle()
) {
    val state = viewModel.loginState.collectAsState()
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = style.contentAlignment,
            modifier = Modifier
                .padding(style.contentPadding)
                .fillMaxSize()
        ) {
            LogInEditText(
                state = state,
                onChangeId = { viewModel.onProcessAction(LoginActionModel.IDChanged(it)) },
                style = style
            )
            PasswordEditText(
                state = state,
                onChangePassword = { viewModel.onProcessAction(LoginActionModel.PasswordChanged(it)) },
                style = style
            )
            LogInButton(
                style = style,
                onLogInClick = {
                    viewModel.onProcessAction(LoginActionModel.LogInClick)
                }
            )
        }
    }
}

@Composable
private fun LogInEditText(
    state: State<com.smartCocktails.login.model.LoginData>,
    onChangeId: (id: String) -> Unit,
    style: LoginScreenStyle,
) {
    BasicEditText(
        text = state.value.id,
        modifier = Modifier.padding(style.loginTextPadding),
        hint = stringResource(R.string.login_enter_id),
        keyboardType = KeyboardType.Number
    ) {
        onChangeId(it)
    }
}

@Composable
private fun PasswordEditText(
    state: State<com.smartCocktails.login.model.LoginData>,
    onChangePassword: (password: String) -> Unit,
    style: LoginScreenStyle,
) {
    BasicEditText(
        text = state.value.password,
        modifier = Modifier.padding(style.passwordTextPadding),
        hint = stringResource(R.string.login_enter_password),
        editTextType = EditTextType.PASSWORD
    ) {
        onChangePassword(it)
    }
}

@Composable
private fun LogInButton(
    onLogInClick: () -> Unit,
    style: LoginScreenStyle,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BasicButton(
            modifier = Modifier.align(style.loginButtonAlignment),
            text = stringResource(R.string.login_enter_button_text),
            onButtonClick = onLogInClick
        )
    }
}

data class LoginScreenStyle(
    val contentPadding: PaddingValues,
    val contentAlignment: Alignment.Horizontal,
    val logoAlignment: Alignment,
    val loginTextPadding: PaddingValues,
    val passwordTextPadding: PaddingValues,
    val loginButtonAlignment: Alignment
)

fun loginScreenStyle(
    contentPadding: PaddingValues = PaddingValues(top = 40.dp, bottom = 40.dp),
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    logoAlignment: Alignment = Alignment.Center,
    loginTextPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    passwordTextPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    loginButtonAlignment: Alignment = Alignment.BottomCenter,
) = LoginScreenStyle(
    contentPadding = contentPadding,
    contentAlignment = contentAlignment,
    logoAlignment = logoAlignment,
    loginTextPadding = loginTextPadding,
    passwordTextPadding = passwordTextPadding,
    loginButtonAlignment = loginButtonAlignment
)