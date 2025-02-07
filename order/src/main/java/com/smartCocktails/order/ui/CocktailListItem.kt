package com.smartCocktails.order.ui

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.smartCocktails.order.model.CocktailItemsListData

@Composable
fun CocktailListItem(
    itemData: CocktailItemsListData,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(130.dp)
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
    itemData: CocktailItemsListData
){
    Row(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        ItemImage(itemData = itemData)
        ItemName(itemData = itemData)
    }
}

@Composable
fun RowScope.ItemImage(
    modifier: Modifier = Modifier,
    itemData: CocktailItemsListData
){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(itemData.image)
            .build(),
        contentDescription = "",
        modifier = modifier.size(100.dp).clip(RoundedCornerShape(50)).align(Alignment.CenterVertically)
    )
}

@Composable
fun RowScope.ItemName(
    modifier: Modifier = Modifier,
    itemData: CocktailItemsListData,
){
    Box(modifier = modifier.align(Alignment.CenterVertically).padding(start = 24.dp)) {
        Text(
            text = itemData.name
        )
    }

}