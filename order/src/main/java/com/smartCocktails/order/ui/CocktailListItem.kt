package com.smartCocktails.order.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import com.smartCocktails.order.R
import com.smartCocktails.order.model.CocktailListItemData

@Composable
fun CocktailListItem(
    itemData: CocktailListItemData,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .padding(vertical = 8.dp,
                horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        ),
        onClick = onItemClick,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(com.smartCocktails.cores.R.color.white)
        )
    ) {
        ItemRow(itemData = itemData)
    }
}

@Composable
private fun ItemRow(
    modifier: Modifier = Modifier,
    itemData: CocktailListItemData
){
    Row(Modifier.fillMaxSize()) {
        ItemImage(itemData = itemData)
        ItemName(itemData = itemData)


    }
}

@Composable
fun RowScope.ItemImage(
    modifier: Modifier = Modifier,
    itemData: CocktailListItemData
){
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(itemData.image)
                .error(R.drawable.configure_cocktail)
                .build()
        ),
        contentDescription = "",
        modifier = modifier.size(120.dp)
    )
}

@Composable
fun RowScope.ItemName(
    modifier: Modifier = Modifier,
    itemData: CocktailListItemData,
){
    Box(modifier = modifier.align(Alignment.CenterVertically).padding(horizontal = 16.dp)) {
        Text(
            text = itemData.name
        )
    }

}