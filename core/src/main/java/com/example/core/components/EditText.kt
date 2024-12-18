package com.example.core.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    hint :String,
    onChangeValue:(value: String)->Unit
){
    val text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {onChangeValue(it) },
        label = { Text(hint) },
        singleLine = true,
        modifier = modifier
    )
}