package com.example.smartcocktail.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.core.ui.components.BasicEditText
import com.example.core.ui.components.EditTextType
import com.example.smartcocktail.R
import com.example.smartcocktail.login.LoginViewModel
import com.example.smartcocktail.login.model.LoginActionModel
import com.example.smartcocktail.login.model.LoginData

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
            Logo(style)
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
fun Logo(
    style: LoginScreenStyle
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.align(style.logoAlignment)
        )
    }
}

@Composable
fun LogInEditText(
    state: State<LoginData>,
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
fun PasswordEditText(
    state: State<LoginData>,
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
fun LogInButton(
    onLogInClick: () -> Unit,
    style: LoginScreenStyle,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = onLogInClick,
            modifier = Modifier
                .padding(style.loginButtonPadding)
                .align(style.loginButtonAlignment)
                .fillMaxWidth(),
        ) {
            Text(stringResource(R.string.login_enter_button_text))
        }
    }
}

data class LoginScreenStyle(
    val contentPadding: PaddingValues,
    val contentAlignment: Alignment.Horizontal,
    val logoAlignment: Alignment,
    val loginTextPadding: PaddingValues,
    val passwordTextPadding: PaddingValues,
    val loginButtonPadding: PaddingValues,
    val loginButtonAlignment: Alignment
)

fun loginScreenStyle(
    contentPadding: PaddingValues = PaddingValues(top = 100.dp, bottom = 40.dp),
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    logoAlignment: Alignment = Alignment.Center,
    loginTextPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    passwordTextPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    loginButtonPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    loginButtonAlignment: Alignment = Alignment.BottomCenter,
) = LoginScreenStyle(
    contentPadding = contentPadding,
    contentAlignment = contentAlignment,
    logoAlignment = logoAlignment,
    loginTextPadding = loginTextPadding,
    passwordTextPadding = passwordTextPadding,
    loginButtonPadding = loginButtonPadding,
    loginButtonAlignment = loginButtonAlignment
)