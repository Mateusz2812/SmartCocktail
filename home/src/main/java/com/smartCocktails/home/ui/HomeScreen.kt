package com.smartCocktails.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.smartCocktails.core.ui.components.BasicTile
import com.smartCocktails.core.ui.components.defaultTileStyle
import com.smartCocktails.home.HomeViewModel
import com.smartCocktails.home.model.HomeIntent
import com.smartCocktails.cores.R as appCore

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Card(
        modifier = Modifier.fillMaxSize(), colors = CardDefaults.cardColors(
            containerColor = colorResource(
                com.smartCocktails.cores.R.color.white
            )
        )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            OrderTile(viewModel)
            ShowCocktailsTile(viewModel)
            ConfigureCocktailsTile(viewModel)
        }
    }
}

@Composable
fun OrderTile(
    viewModel: HomeViewModel
) {
    BasicTile(
        titleText = stringResource(R.string.home_order_tile_text),
        descriptionText = stringResource(R.string.home_order_description_text),
        imagePainter = painterResource(R.drawable.logo_app),
        onTileClick = { viewModel.handleEvent(HomeIntent.GoToOrderCocktail) }
    )
}

@Composable
fun ShowCocktailsTile(
    viewModel: HomeViewModel
) {
    BasicTile(
        titleText = stringResource(R.string.home_show_cocktails_tile_text),
        descriptionText = stringResource(R.string.home_show_cocktails_description_text),
        imagePainter = painterResource(R.drawable.cocktails_list),
        onTileClick = { viewModel.handleEvent(HomeIntent.ShowCocktails) },
        style = defaultTileStyle(
            tileColor = colorResource(appCore.color.black),
            tileTextColor = colorResource(appCore.color.white),
            descriptionTextColor = colorResource(appCore.color.gray),
        )
    )
}

@Composable
fun ConfigureCocktailsTile(
    viewModel: HomeViewModel
) {
    BasicTile(
        titleText = stringResource(R.string.home_configure_tile_text),
        descriptionText = stringResource(R.string.home_configure_description_text),
        imagePainter = painterResource(R.drawable.configure_cocktail),
        onTileClick = { viewModel.handleEvent(HomeIntent.GoToConfigureCocktail) }
    )
}