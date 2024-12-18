package com.example.smartcocktail.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core.components.EditText
import com.example.smartcocktail.R
import com.example.smartcocktail.login.LoginViewModel
import com.example.smartcocktail.login.model.LoginActionModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {
        Column {
            Logo()
            LogInEditText(viewModel)
            PasswordEditText(viewModel)
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
    viewModel: LoginViewModel
) {
    EditText(
        modifier = Modifier.padding(top = 20.dp),
        hint = stringResource(R.string.login_enter_id)
    ) {
        viewModel.onProcessAction(LoginActionModel.IDChanged(it))
    }
}

@Composable
fun PasswordEditText(
    viewModel: LoginViewModel
) {
    EditText(
        modifier = Modifier.padding(top = 20.dp),
        hint = stringResource(R.string.login_enter_password)
    ) {
        viewModel.onProcessAction(LoginActionModel.PasswordChanged(it))
    }
}