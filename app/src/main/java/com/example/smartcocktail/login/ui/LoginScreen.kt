package com.example.smartcocktail.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import com.example.core.components.BasicEditText
import com.example.smartcocktail.R
import com.example.smartcocktail.login.LoginViewModel
import com.example.smartcocktail.login.model.LoginActionModel
import com.example.smartcocktail.login.model.LoginData

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    val state = viewModel.loginState.collectAsState()
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            LogInEditText(
                state = state,
                onChangeId = { viewModel.onProcessAction(LoginActionModel.IDChanged(it)) }
            )
            PasswordEditText(
                state = state,
                onChangePassword = { viewModel.onProcessAction(LoginActionModel.PasswordChanged(it)) }
            )
            LogInButton {
                viewModel.onProcessAction(LoginActionModel.LogInClick)
            }
        }
    }
}

@Composable
fun Logo() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun LogInEditText(
    state: State<LoginData>,
    onChangeId: (id: String) -> Unit
) {
    BasicEditText(
        text = state.value.id,
        modifier = Modifier.padding(top = 20.dp),
        hint = stringResource(R.string.login_enter_id)
    ) {
        onChangeId(it)
    }
}

@Composable
fun PasswordEditText(
    state: State<LoginData>,
    onChangePassword: (password: String) -> Unit
) {
    BasicEditText(
        text = state.value.password,
        modifier = Modifier.padding(top = 20.dp),
        hint = stringResource(R.string.login_enter_password)
    ) {
        onChangePassword(it)
    }
}

@Composable
fun LogInButton(
    onLogInClick:() -> Unit
){
    Button(
        onClick = onLogInClick,
        modifier = Modifier.padding(top = 20.dp),
    ) {
        Text(stringResource(R.string.login_enter_button_text))
    }
}