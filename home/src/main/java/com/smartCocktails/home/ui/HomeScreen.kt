package com.smartCocktails.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.smartCocktails.home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.dataState.collectAsState()
    Card(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {}) { }
        LazyColumn(state = rememberLazyListState()) {
            items(state.value){

            }
        }
    }
}