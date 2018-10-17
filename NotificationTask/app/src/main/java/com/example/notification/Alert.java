package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ${Aina} on 17.10.2018.
 */
public class Alert extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentResult = new Intent(context, WakeUpActivity.class);
        intentResult.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 555, intentResult, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "5")
                .setContentTitle("Wake up")
                .setSmallIcon(R.drawable.icon)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentText("Your time is left")
                .setVisibility(Notification.VISIBILITY_PRIVATE)
                .setContentIntent(pendingIntent);
        Notification notification = notificationBuilder.build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("5", "channel1", importance);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
            channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), channel.getAudioAttributes());
        }
        notificationManager.notify(1, notification);
    }
}
