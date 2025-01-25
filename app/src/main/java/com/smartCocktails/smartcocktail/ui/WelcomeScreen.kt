package com.smartCocktails.smartcocktail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.components.BasicButton
import com.smartCocktails.core.ui.components.borderButtonStyle
import com.smartCocktails.core.ui.components.defaultButtonStyle
import com.smartCocktails.core.ui.style.buttonBaseTextStyle
import com.smartCocktails.smartcocktail.R

@Composable
fun WelcomeScreen(
    onClick: () -> Unit,
    style: WelcomeScreenStyle = welcomeScreenStyle()
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.welcome_screen_logo_background))
    ) {
        Box(
            modifier = Modifier
                .padding(style.contentPadding)
                .fillMaxSize()
        ) {
            Logo(style)
            WelcomeBottomButton(
                style = style,
                onClick = { onClick() }
            )
        }
    }
}

@Composable
private fun Logo(
    style: WelcomeScreenStyle
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier
                .align(style.logoAlignment)
                .size(style.logoSize)
        )
    }
}

@Composable
private fun WelcomeBottomButton(
    onClick: () -> Unit,
    style: WelcomeScreenStyle,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BasicButton(
            modifier = Modifier.align(style.buttonAlignment),
            text = stringResource(R.string.welcome_button_text),
            onButtonClick = onClick,
            style = borderButtonStyle(
                buttonColor = style.buttonColor,
                buttonTextStyle = style.buttonTextStyle,
                buttonBorderStroke = style.buttonBorderStroke
            )
        )
    }
}

@Composable
fun welcomeScreenStyle(
    contentPadding: PaddingValues = PaddingValues(top = 100.dp, bottom = 40.dp),
    logoAlignment: Alignment = Alignment.Center,
    logoSize: DpSize = DpSize(2400.dp, 280.dp),
    buttonAlignment: Alignment = Alignment.BottomCenter,
    buttonColor: Color = colorResource(R.color.welcome_screen_button_color),
    buttonTextStyle: TextStyle = buttonBaseTextStyle.copy(
        color = colorResource(com.smartCocktails.cores.R.color.white),
    ),
    buttonBorderStroke: BorderStroke = BorderStroke(width = 1.dp, color = colorResource(com.smartCocktails.cores.R.color.white)),
) = WelcomeScreenStyle(
    contentPadding = contentPadding,
    logoAlignment = logoAlignment,
    logoSize = logoSize,
    buttonAlignment = buttonAlignment,
    buttonColor = buttonColor,
    buttonTextStyle = buttonTextStyle,
    buttonBorderStroke = buttonBorderStroke
)

data class WelcomeScreenStyle(
    val contentPadding: PaddingValues,
    val logoAlignment: Alignment,
    val logoSize: DpSize,
    val buttonAlignment: Alignment,
    val buttonColor: Color,
    val buttonTextStyle: TextStyle,
    val buttonBorderStroke: BorderStroke
)
