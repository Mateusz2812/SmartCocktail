package com.example.home

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.core.base.BaseActivity
import com.example.home.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    override fun afterViews() {
        applyBackPressed()
    }


    @Composable
    override fun ContentView() {
        HomeScreen()
    }

    private fun applyBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                logout()
            }
        })
    }

    private fun logout() {
        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.exit_popup_title))
            .setMessage(getString(R.string.exit_popup_description))
            .setPositiveButton(getString(R.string.exit_popup_positive_button)) { _, _ ->

            }
            .setNegativeButton(getString(R.string.exit_popup_negative_button)) { dialog, _ ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }


    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}