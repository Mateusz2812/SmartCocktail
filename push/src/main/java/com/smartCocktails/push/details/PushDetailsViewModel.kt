package com.smartCocktails.push.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.push.details.model.PushDetailsIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PushDetailsViewModel @Inject constructor(
    val internalNavigator: InternalNavigator
) : ViewModel() {

    private val pushDetailsEvent = MutableSharedFlow<PushDetailsIntent>()
    val getPushDetailsEvent = pushDetailsEvent

    fun setEvent(event: PushDetailsIntent) {
        viewModelScope.launch { pushDetailsEvent.emit(event) }
    }

    fun redirectToUserOrdersList(activity: BaseActivity) {
        internalNavigator.redirectInternalLink(
            activity = activity,
            code = AppInternalCodes.USER_ORDERS_LIST
        )
    }
}