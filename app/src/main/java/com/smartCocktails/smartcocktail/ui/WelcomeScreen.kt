package com.smartCocktails.smartcocktail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.components.BasicButton
import com.smartCocktails.smartcocktail.R

@Composable
fun WelcomeScreen(
    onClick: () -> Unit,
    style: WelcomeScreenStyle = welcomeScreenStyle()
) {
    Card(
        modifier = Modifier.fillMaxSize()
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
            painter = painterResource(R.drawable.ic_logo),
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
        )
    }
}

fun welcomeScreenStyle(
    contentPadding: PaddingValues = PaddingValues(top = 100.dp, bottom = 40.dp),
    logoAlignment: Alignment = Alignment.Center,
    logoSize: DpSize = DpSize(2400.dp, 280.dp),
    buttonAlignment: Alignment = Alignment.BottomCenter,
) = WelcomeScreenStyle(
    contentPadding = contentPadding,
    logoAlignment = logoAlignment,
    logoSize = logoSize,
    buttonAlignment = buttonAlignment
)

data class WelcomeScreenStyle(
    val contentPadding: PaddingValues,
    val logoAlignment: Alignment,
    val logoSize: DpSize,
    val buttonAlignment: Alignment
)
