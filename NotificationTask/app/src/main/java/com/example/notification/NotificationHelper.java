package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ${Aina} on 18.10.2018.
 */
public class NotificationHelper {

    public Notification provideNotification(Context context) {
        Intent intentResult = new Intent(context, WakeUpActivity.class);
        intentResult.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 555, intentResult, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "5")
                .setContentTitle("Wake up")
                .setSmallIcon(R.drawable.icon)
                .setColor(context.getResources().getColor(R.color.colorMain))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentText("Your time is left")
                .setVisibility(Notification.VISIBILITY_PRIVATE)
                .setContentIntent(pendingIntent);
        Notification notification = notificationBuilder.build();
        return notification;
    }
}
