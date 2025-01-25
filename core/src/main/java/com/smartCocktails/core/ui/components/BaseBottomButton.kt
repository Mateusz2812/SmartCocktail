package com.smartCocktails.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.style.buttonBaseTextStyle
import com.smartCocktails.cores.R


@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit,
    style: BasicButtonStyle = defaultButtonStyle()
) {
    Button(
        onClick = onButtonClick,
        modifier = modifier
            .padding(style.buttonPadding)
            .fillMaxWidth(),
        border = style.buttonBorderStroke,
        colors = ButtonDefaults.buttonColors(
            containerColor = style.buttonColor
        )
    ) {
        Text(
            text = text,
            style = style.buttonTextStyle
        )
    }
}

@Composable
fun BasicBorderButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit,
    style: BasicButtonStyle = borderButtonStyle()
) {
    BasicButton(
        modifier, text, onButtonClick, style
    )
}


@Composable
fun defaultButtonStyle(
    buttonColor: Color = colorResource(R.color.colorPrimary),
    buttonPadding: PaddingValues = PaddingValues(top = 20.dp, start = 16.dp, end = 16.dp),
    buttonAlignment: Alignment = Alignment.BottomCenter,
    buttonBorderStroke: BorderStroke = BorderStroke(
        width = 0.dp,
        color = colorResource(R.color.white)
    ),
    buttonTextStyle: TextStyle = buttonBaseTextStyle
) = BasicButtonStyle(
    buttonColor = buttonColor,
    buttonPadding = buttonPadding,
    buttonAlignment = buttonAlignment,
    buttonBorderStroke = buttonBorderStroke,
    buttonTextStyle = buttonTextStyle

)

@Composable
fun borderButtonStyle(
    buttonColor: Color = colorResource(R.color.white),
    buttonBorderStroke: BorderStroke = BorderStroke(width = 1.dp, color = colorResource(R.color.colorPrimary)),
    buttonTextStyle: TextStyle = buttonBaseTextStyle.copy(
        color = colorResource(R.color.colorPrimary),
    )
): BasicButtonStyle = defaultButtonStyle(
    buttonColor = buttonColor,
    buttonBorderStroke = buttonBorderStroke,
    buttonTextStyle = buttonTextStyle
)

data class BasicButtonStyle(
    val buttonColor: Color,
    val buttonPadding: PaddingValues,
    val buttonAlignment: Alignment,
    val buttonBorderStroke: BorderStroke,
    val buttonTextStyle: TextStyle,
)