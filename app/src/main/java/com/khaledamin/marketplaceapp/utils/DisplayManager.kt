package com.khaledamin.marketplaceapp.utils

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_MUTABLE
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.ui.authentication.signup.SignupActivity
import com.khaledamin.marketplaceapp.ui.authentication.verification.VerificationActivity

@RequiresApi(Build.VERSION_CODES.S)
fun createNotification(verificationCode:String, application: Application,numberEntry:String){

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

        val channel = NotificationChannel(Constants.CHANNEL_ID,Constants.CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager = application.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    val intent = Intent(application,SignupActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent = PendingIntent.getActivity(application,0,null,FLAG_MUTABLE)

    val builder = NotificationCompat.Builder(application,Constants.CHANNEL_ID)
        .setSmallIcon(R.drawable.thumbnail)
        .setContentTitle("Verification code")
        .setContentText(verificationCode)
        .setStyle(NotificationCompat.BigTextStyle().bigText(verificationCode))
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_CALL)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(application)) {
        notify(Constants.NOTIFICATION_ID,builder.build())
    }
}