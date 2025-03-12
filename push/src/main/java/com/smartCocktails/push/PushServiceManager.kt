package com.smartCocktails.push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.smartCocktails.push.details.PushDetailsActivity
import javax.inject.Inject


class PushServiceManager @Inject constructor() {

    fun onMessageReceived(context: Context, message: RemoteMessage) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(com.google.android.gms.base.R.drawable.googleg_disabled_color_18)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(getPushIntent(context))

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        manager?.notify(1, builder.build())
    }

    private fun getPushIntent(context: Context): PendingIntent?{
        return PendingIntent.getActivity(context,0, PushDetailsActivity.prepareIntent(context),
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE )
    }

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