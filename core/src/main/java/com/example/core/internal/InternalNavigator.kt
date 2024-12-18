package com.example.core.internal

import javax.inject.Inject

class InternalNavigator @Inject constructor() {

    fun redirect(code: RedirectCode) {
        when (code) {
            RedirectCode.HOW_TO_LOGIN -> {

            }

            else -> {}
        }
    }
}