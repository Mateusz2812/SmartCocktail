package com.example.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun BasicEditText(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String,
    editTextType: EditTextType = EditTextType.TEXT,
    onChangeValue: (value: String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = {
            onChangeValue(it)
        },
        label = { Text(hint) },
        singleLine = true,
        visualTransformation = if (editTextType == EditTextType.PASSWORD) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType =
            if (editTextType == EditTextType.PASSWORD) {
                KeyboardType.Password
            } else {
                KeyboardType.Text
            }
        ),
        modifier = modifier.fillMaxWidth()
    )
}

enum class EditTextType {
    PASSWORD,
    TEXT,
    NUMBERS
}