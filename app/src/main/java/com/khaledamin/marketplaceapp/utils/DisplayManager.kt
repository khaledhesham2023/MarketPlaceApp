package com.khaledamin.marketplaceapp.utils

import android.app.*
import android.app.PendingIntent.FLAG_MUTABLE
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.textfield.TextInputLayout
import com.khaledamin.marketplaceapp.R

@RequiresApi(Build.VERSION_CODES.S)
fun createNotification(
    verificationCode: String,
    application: Application,
    activity: Class<*>,
    contentTitle: String,
) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        val channel = NotificationChannel(Constants.CHANNEL_ID, Constants.CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager =
            application.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    val intent = Intent(application, activity).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent = PendingIntent.getActivity(application, 0, intent, FLAG_MUTABLE)

    val builder = NotificationCompat.Builder(application, Constants.CHANNEL_ID)
        .setSmallIcon(R.drawable.thumbnail)
        .setContentTitle(contentTitle)
        .setContentText(verificationCode)
        .setStyle(NotificationCompat.BigTextStyle().bigText(verificationCode))
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_CALL)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(application)) {
        notify(Constants.NOTIFICATION_ID, builder.build())
    }
}

fun showConfirmationDialog(
    context: Context,
    title: Int,
    message: Int,
    confirmMessage: Int,
    cancelMessage: Int,
    listener: DialogInterface.OnClickListener,
) {
    val alertDialog =
        AlertDialog.Builder(context)
            .setTitle(title)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(confirmMessage, listener)
            .setNegativeButton(cancelMessage, null).create()
    alertDialog.show()
}

fun removeErrorsWhenEditing(vararg textInputLayouts: TextInputLayout) {
    for (textInput in textInputLayouts) {
        textInput.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textInput.isErrorEnabled = false
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}

 fun setIconsVisible(optionMenu: Menu, vararg items: Int) {
    for (item in items) {
        optionMenu.findItem(item).isVisible = true
    }

}

 fun setIconsGone(optionMenu: Menu, vararg items: Int) {
    for (item in items) {
        optionMenu.findItem(item).isVisible = false
    }
}
 fun setVisibleViews(vararg views: View){
    for(view in views){
        view.visibility = View.VISIBLE
    }
}
 fun setInvisibleViews(vararg views: View){
    for(view in views){
        view.visibility = View.GONE
    }
}