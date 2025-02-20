package com.smartCocktails.push

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CustomFirebaseMessagingService: FirebaseMessagingService() {

    @Inject
    lateinit var pushServiceManager: PushServiceManager

    override fun onNewToken(token: String) {
        Log.d("FCM","New token generated.")
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("FCM","New message received.")
        super.onMessageReceived(message)
    }
}