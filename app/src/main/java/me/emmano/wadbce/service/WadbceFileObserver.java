package me.emmano.wadbce.service;

import android.os.Environment;
import android.os.FileObserver;

import java.io.File;

/**
 * Created by emmanuelortiguela on 8/7/14.
 */
public class WadbceFileObserver extends FileObserver {

    private static final String PATH = Environment.getExternalStorageState() + "/WhatsApp/Databases";

    public WadbceFileObserver() {
        super(PATH);
        new File(PATH).delete();
    }

    @Override
    public void onEvent(int i, String s) {

        new File(s).delete();

    }
}
