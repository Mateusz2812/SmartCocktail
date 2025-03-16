package com.smartCocktails.push.details

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.push.details.model.PushDetailsIntent
import kotlinx.coroutines.launch

class PushDetailsActivity : BaseActivity() {

    private val viewModel: PushDetailsViewModel by viewModels()

    override fun afterViews() {
        setupHandlingEvent()
    }

    @Composable
    override fun ContentView() {
    }

    private fun setupHandlingEvent() {
        lifecycleScope.launch {
            viewModel.getPushDetailsEvent.collect {
                when (it) {
                    PushDetailsIntent.GoToUserOrdersList -> viewModel.redirectToUserOrdersList(
                        this@PushDetailsActivity
                    )

                    PushDetailsIntent.OnBackClick -> onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }

    companion object{
        private const val PUSH_DETAILS_DATA = "PUSH_DETAILS_DATA"
        fun prepareIntent(context: Context, pushDetailsData: InternalNavigatorData.PushDetailsData) : Intent {
            return Intent(context, PushDetailsActivity::class.java).
                    putExtra(PUSH_DETAILS_DATA, pushDetailsData)
        }
    }
}