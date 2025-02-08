package com.smartCocktails.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.smartCocktails.core.ui.style.bigTextBold
import com.smartCocktails.core.ui.style.mediumTextBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
) {
    TopBarWithBackAndAction(
        title = title,
        showBackIcon = false,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBack(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit
) {
    TopBarWithBackAndAction(
        title = title,
        onBackClick = onBackClick,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackAndAction(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit = {},
    showBackIcon: Boolean = true,
    @DrawableRes actionIcon: Int? = null,
    onActionClick: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = bigTextBold.copy(fontSize = 20.sp)
            )
        },
        navigationIcon = {
            if (!showBackIcon) {
                return@TopAppBar
            }
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            if (actionIcon == null) {
                return@TopAppBar
            }
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = painterResource(actionIcon),
                    contentDescription = "More options"
                )
            }
        },
        modifier = modifier
    )
}