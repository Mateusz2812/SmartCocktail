package com.smartCocktails.push.details.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.smartCocktails.core.ui.components.TopBarWithBack
import com.smartCocktails.push.R
import com.smartCocktails.push.details.PushDetailsViewModel
import com.smartCocktails.push.details.model.PushDetailsData
import com.smartCocktails.push.details.model.PushDetailsIntent

@Composable
fun PushDetailsScreen(
    viewModel: PushDetailsViewModel
) {
    val state = viewModel.getPushDetailsState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithBack(
                title = stringResource(R.string.push_details_top_bar),
                onBackClick = { viewModel.setEvent(PushDetailsIntent.OnBackClick) }
            )
        }
    ) { paddingValues ->
        PushDetailsContent(
            pushDetailsData = state.value.pushDetailsData,
            modifier = Modifier.padding(paddingValues),
            )
    }
}

@Composable
fun PushDetailsContent(
    pushDetailsData: PushDetailsData,
    modifier: Modifier = Modifier
){

}