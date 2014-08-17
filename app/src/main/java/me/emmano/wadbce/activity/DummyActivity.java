package me.emmano.wadbce.activity;

import com.google.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import me.emmano.wadbce.R;
import me.emmano.wadbce.notification.NotificationDispatcher;
import me.emmano.wadbce.service.FileWatcherService;
import roboguice.activity.RoboActivity;


public class DummyActivity extends RoboActivity {

    @Inject
    private NotificationDispatcher notificationDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, FileWatcherService.class));
        notificationDispatcher.dispatch(R.string.wadbce_is_running);
        finish();
    }

}
