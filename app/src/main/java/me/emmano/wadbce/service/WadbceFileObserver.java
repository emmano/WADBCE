package me.emmano.wadbce.service;

import com.google.inject.Inject;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v4.app.NotificationCompat;

import java.io.File;

import me.emmano.wadbce.R;

/**
 * Created by emmanuelortiguela on 8/7/14.
 */
public class WadbceFileObserver extends FileObserver {

    private static final String PATH = Environment.getExternalStorageDirectory()
            + "/WhatsApp/Databases/";

    public static final int NOTIFICATION_ID = 1;

    private final File databases;

    @Inject
    private Context context;

    @Inject
    private NotificationManager manager;

    @Inject
    private NotificationCompat.Builder notificationBuilder;

    public WadbceFileObserver() {
        super(PATH);
        databases = new File(PATH);
    }

    @Override
    public void onEvent(int flag, String s) {
        //Android bug.
        flag &= ALL_EVENTS;
        if (flag == CREATE || flag == MOVED_TO) {
            deleteDatabaseCopies();
        }
    }

    public void deleteDatabaseCopies() {
        if (databases.isDirectory() && databases.list().length != 0) {
            for (String s : databases.list()) {
                new File(databases, s).delete();
            }
            notificationBuilder
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentText("WADBCE removed files")
                    .setContentTitle("WADBCE");
            final Notification notification = notificationBuilder.build();

            manager.notify(NOTIFICATION_ID, notification);
        }

    }
}
