package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

/**
 * Created by ${Aina} on 17.10.2018.
 */
public class Alert extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String channelId = "5";
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, "channel1", importance);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
            channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), channel.getAudioAttributes());
        }
        NotificationHelper helper = new NotificationHelper();
        notificationManager.notify(1, helper.provideNotification(context));
    }
}
