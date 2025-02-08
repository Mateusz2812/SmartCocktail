package com.smartCocktails.order.details.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.components.TopBarWithBack
import com.smartCocktails.order.R
import com.smartCocktails.order.details.CocktailDetailsViewModel
import com.smartCocktails.order.details.model.CocktailDetailsIntent

@Composable
fun CocktailDetailsScreen(
    viewModel: CocktailDetailsViewModel
) {
    val state = viewModel.getCocktailDetailsState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithBack(
                title = stringResource(R.string.cocktail_details_top_bar),
                onBackClick = { viewModel.setEvent(CocktailDetailsIntent.OnBackClick) }
            )
        }
    ) { paddingValues ->
        CocktailDetails(
            modifier = Modifier.padding(paddingValues),
            isFavourite = state.value.isFavourite,
            onFavouriteClick = { viewModel.setEvent(CocktailDetailsIntent.FavouriteCocktail) })
    }
}

@Composable
fun CocktailDetails(
    modifier: Modifier = Modifier,
    isFavourite: Boolean,
    onFavouriteClick: () -> Unit
) {
    Box(modifier.fillMaxSize()) {
        Card { }
        FloatingFavoriteButton(
            isFavourite = isFavourite,
            onClick = onFavouriteClick
        )
    }
}

@Composable
fun BoxScope.FloatingFavoriteButton(
    isFavourite: Boolean = false,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomEnd)
    ) {
        Icon(
            imageVector = if (isFavourite) {
                Icons.Filled.Star
            } else {
                Icons.Outlined.Star
            },
            contentDescription = null,
            tint = if (isFavourite) {
                Color.Yellow
            } else {
                Color.Gray
            }
        )
    }
}