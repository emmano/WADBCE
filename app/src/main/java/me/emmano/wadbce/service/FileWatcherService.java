package me.emmano.wadbce.service;


import com.google.inject.Inject;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import roboguice.service.RoboService;

/**
 * Created by emmanuelortiguela on 8/7/14.
 */
public class FileWatcherService extends RoboService {

    @Inject
    private WadbceFileObserver fileObserver;

    public static final int SERVICE_ID = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        fileObserver.deleteFilesInDirectory();
        fileObserver.startWatching();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return Service.START_STICKY;
    }
}
