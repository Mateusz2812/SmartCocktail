package com.smartCocktails.order.details.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.smartCocktails.core.ui.components.TopBarWithBack
import com.smartCocktails.core.ui.style.mediumText
import com.smartCocktails.core.ui.style.mediumTextBold
import com.smartCocktails.core.ui.style.mediumTextMedium
import com.smartCocktails.core.ui.style.smallTextMedium
import com.smartCocktails.order.R
import com.smartCocktails.order.details.CocktailDetailsViewModel
import com.smartCocktails.order.details.model.CocktailDetailsIntent
import com.smartCocktails.order.details.model.CocktailDetailsState
import com.smartCocktails.order.model.CocktailItemDetailsData

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
            state = state,
            onFavouriteClick = { viewModel.setEvent(CocktailDetailsIntent.FavouriteCocktail) })
    }
}

@Composable
fun CocktailDetails(
    modifier: Modifier = Modifier,
    state: State<CocktailDetailsState>,
    onFavouriteClick: () -> Unit
) {
    Box(modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        state.value.details?.let {
            CocktailDetailsCard(it)
        }

        FloatingFavoriteButton(
            isFavourite = state.value.isFavourite,
            onClick = onFavouriteClick
        )
    }
}

@Composable
fun CocktailDetailsCard(
    details: CocktailItemDetailsData
) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(com.smartCocktails.cores.R.color.lightYellow)
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(details.image)
                    .build(),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .width(200.dp)
            )
            Ingredients(details)
        }
    }
}

@Composable
fun Ingredients(
    details: CocktailItemDetailsData
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
        Text(
            stringResource(R.string.cocktail_details_ingredients_label),
            style = mediumTextBold
        )
        LazyColumn(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(details.ingredients) {
                Text("\u25AA $it", style = smallTextMedium.copy(fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun BoxScope.FloatingFavoriteButton(
    isFavourite: Boolean = false,
    onClick: () -> Unit
) {
    FloatingActionButton(
        shape = CircleShape,
        modifier = Modifier
            .border(width = 1.dp, shape = CircleShape, color = Color.Gray)
            .align(Alignment.BottomEnd),
        onClick = { onClick() },
        containerColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = if (isFavourite) {
                colorResource(com.smartCocktails.cores.R.color.darkYellow)
            } else {
                colorResource(com.smartCocktails.cores.R.color.gray)
            },
            modifier = Modifier.size(68.dp).padding(4.dp)
        )
    }
}