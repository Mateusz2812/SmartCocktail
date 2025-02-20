package com.smartCocktails.push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import javax.inject.Inject


class PushServiceManager @Inject constructor() {

    fun onMessageReceived() {}


    fun createNotificationChannel(context: Context) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = CHANNEL_DESCRIPTION
        channel.enableVibration(true)

        val manager: NotificationManager =
            context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    companion object {
        private const val CHANNEL_ID: String = "70001"
        private const val CHANNEL_NAME: String = "App notification"
        private const val CHANNEL_DESCRIPTION: String = "Notification"
    }
}