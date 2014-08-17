package me.emmano.wadbce.notification;

import com.google.inject.Inject;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import me.emmano.wadbce.R;

/**
 * Created by emmanuelortiguela on 8/16/14.
 */
public class NotificationDispatcher {

    public static final int ID = 1;

    @Inject
    private NotificationManager notificationManager;

    @Inject
    NotificationCompat.Builder notificationBuilder;

    @Inject
    private Context context;

    public void dispatch(int contentTextResourceId) {

        notificationBuilder
                .setContentText(context.getString(contentTextResourceId))
                .setSmallIcon(R.drawable.wadbce_icon)
                .setContentTitle(context.getString(R.string.app_name));

        final Notification notification = notificationBuilder.build();

        notificationManager.notify(NotificationDispatcher.ID, notification);
    }
}