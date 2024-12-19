package com.example.core.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BasicEditText(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String,
    onChangeValue: (value: String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = {
            onChangeValue(it)
        },
        label = { Text(hint) },
        singleLine = true,
        modifier = modifier
    )
}