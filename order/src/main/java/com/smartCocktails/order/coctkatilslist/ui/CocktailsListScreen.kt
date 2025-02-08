package com.smartCocktails.order.coctkatilslist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.ui.components.TopBarWithBack
import com.smartCocktails.order.R
import com.smartCocktails.order.coctkatilslist.CocktailsListViewModel
import com.smartCocktails.order.coctkatilslist.model.CocktailsListIntent
import com.smartCocktails.order.ui.CocktailListItem

@Composable
fun CocktailsListScreen(
    viewModel: CocktailsListViewModel
) {
    val state = viewModel.getCocktailsListState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithBack(
                title = stringResource(R.string.cocktails_list_top_bar),
                onBackClick = { viewModel.setEvent(CocktailsListIntent.OnBackClick) }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(state.value.cocktailsList) {
                CocktailListItem(
                   itemData =  it.transformToCocktailItemData()
                ) {
                    viewModel.setEvent(CocktailsListIntent.ShowDrink(it.idDrink))
                }
            }
        }
    }
}

@Composable
fun SearchWithFilters(
    modifier: Modifier = Modifier,
    query: String = "",
    onQueryChanged: (String) -> Unit

) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = { Text(stringResource(R.string.cocktails_list_search_hint)) },
        singleLine = true,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}