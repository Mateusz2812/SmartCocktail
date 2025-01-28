package com.smartCocktails.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.style.bigTextBold
import com.smartCocktails.core.ui.style.smallText
import com.smartCocktails.cores.R

@Composable
fun BasicTile(
    modifier: Modifier = Modifier,
    titleText: String,
    descriptionText: String,
    imagePainter: Painter,
    onTileClick: () -> Unit,
    style: BasicTileStyle = defaultTileStyle()
) {
    Card(
        modifier = modifier
            .height(style.tileHeight)
            .padding(style.tilePadding)
            .fillMaxWidth(),
        shape = style.tileShape,
        elevation = style.tileElevation,
        onClick = onTileClick,
        colors = CardDefaults.cardColors(containerColor = style.tileColor)
    ) {
        Column(modifier.fillMaxSize()) {
            TileImage(
                imagePainter = imagePainter,
                style = style
            )
            TitleText(
                titleText = titleText,
                style = style
            )
            DescriptionText(
                descriptionText = descriptionText,
                style = style
            )
        }
    }
}

@Composable
fun ColumnScope.TileImage(
    imagePainter: Painter,
    style: BasicTileStyle
) {
    Image(
        painter = imagePainter,
        contentDescription = null,
        modifier = Modifier
            .weight(style.imageWeight)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TitleText(
    titleText: String,
    style: BasicTileStyle
) {
    Text(
        text = titleText,
        modifier = Modifier
            .padding(style.titlePadding)
            .fillMaxWidth(),
        style = style.titleTextStyle.copy(color = style.titleTextColor)
    )
}

@Composable
fun DescriptionText(
    descriptionText: String,
    style: BasicTileStyle
) {
    Text(
        text = descriptionText,
        modifier = Modifier
            .padding(style.descriptionPadding)
            .fillMaxWidth(),
        style = style.descriptionTextStyle.copy(color = style.descriptionTextColor)
    )
}

@Composable
fun defaultTileStyle(
    tileHeight: Dp = 300.dp,
    tilePadding: PaddingValues = PaddingValues(16.dp),
    tileShape: Shape = RoundedCornerShape(16.dp),
    tileElevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp
    ),
    tileColor: Color = colorResource(R.color.white),
    titlePadding: PaddingValues = PaddingValues(start = 24.dp, end = 24.dp, top = 16.dp),
    titleTextStyle: TextStyle = bigTextBold,
    tileTextColor: Color = colorResource(R.color.black),
    descriptionPadding: PaddingValues = PaddingValues(
        start = 24.dp,
        end = 24.dp,
        top = 8.dp,
        bottom = 16.dp
    ),
    descriptionTextStyle: TextStyle = smallText,
    descriptionTextColor: Color = colorResource(R.color.gray),
    imageWeight: Float = 1f,
    imageContentScale: ContentScale = ContentScale.Fit
) = BasicTileStyle(
    tileHeight = tileHeight,
    tilePadding = tilePadding,
    tileShape = tileShape,
    tileElevation = tileElevation,
    tileColor = tileColor,
    titlePadding = titlePadding,
    titleTextStyle = titleTextStyle,
    titleTextColor = tileTextColor,
    descriptionPadding = descriptionPadding,
    descriptionTextStyle = descriptionTextStyle,
    descriptionTextColor = descriptionTextColor,
    imageWeight = imageWeight,
    imageContentScale = imageContentScale
)

data class BasicTileStyle(
    val tileHeight: Dp,
    val tilePadding: PaddingValues,
    val tileShape: Shape,
    val tileElevation: CardElevation,
    val tileColor: Color,
    val titlePadding: PaddingValues,
    val titleTextStyle: TextStyle,
    val titleTextColor: Color,
    val descriptionPadding: PaddingValues,
    val descriptionTextStyle: TextStyle,
    val descriptionTextColor: Color,
    val imageWeight: Float,
    val imageContentScale: ContentScale
)