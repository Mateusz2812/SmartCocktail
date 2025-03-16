package com.smartCocktails.push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.smartCocktails.core.navigator.InternalNavigatorData
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
            .setContentIntent(getPushIntent(context, message))

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        manager?.notify(1, builder.build())
    }

    private fun getPushIntent(context: Context, message: RemoteMessage): PendingIntent? {
        val pushDetailsData = message.getPushData().toPushDetailsData()
        return PendingIntent.getActivity(
            context, 0, PushDetailsActivity.prepareIntent(context, pushDetailsData),
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    private fun RemoteMessage.getPushData(): PushData {
        return PushData(
            id = data[PushData.PUSH_DATA_ID],
            title = data[PushData.PUSH_DATA_TITLE]?: notification?.title,
            subtitle = data[PushData.PUSH_DATA_SUBTITLE]?: notification?.body,
            contextText = data[PushData.PUSH_DATA_CONTEXT],
            graphicId = data[PushData.PUSH_DATA_GRAPHIC_ID],
            enableOrderListRedirect = data[PushData.PUSH_DATA_ORDER_REDIRECT].toBoolean(),
            date = data[PushData.PUSH_DATA_DATE],
        )
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

data class PushData(
    val id: String? = null,
    val title: String? = "",
    val subtitle: String? = "",
    val contextText: String? = "",
    val enableOrderListRedirect: Boolean? = false,
    val date: String? = null,
    val graphicId: String? = null
){
    fun toPushDetailsData(): InternalNavigatorData.PushDetailsData{
        return  InternalNavigatorData.PushDetailsData(
            id = id,
            title = title,
            subtitle = subtitle,
            contextText = contextText,
            enableOrderListRedirect = enableOrderListRedirect,
            date = date,
            graphicId = graphicId
        )
    }
    companion object{
        const val PUSH_DATA_ID = "id"
        const val PUSH_DATA_TITLE = "title"
        const val PUSH_DATA_SUBTITLE = "subtitle"
        const val PUSH_DATA_CONTEXT = "context"
        const val PUSH_DATA_ORDER_REDIRECT= "orderRedirect"
        const val PUSH_DATA_GRAPHIC_ID = "graphicId"
        const val PUSH_DATA_DATE = "date"
    }
}