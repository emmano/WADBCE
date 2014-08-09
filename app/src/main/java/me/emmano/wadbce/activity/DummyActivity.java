package me.emmano.wadbce.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import me.emmano.wadbce.service.FileWatcherService;


public class DummyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, FileWatcherService.class));
        finish();
    }

}
