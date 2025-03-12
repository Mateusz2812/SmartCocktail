package com.smartCocktails.push.details.model

sealed class PushDetailsIntent {
    data object OnBackClick : PushDetailsIntent()
    data object GoToUserOrdersList : PushDetailsIntent()
}