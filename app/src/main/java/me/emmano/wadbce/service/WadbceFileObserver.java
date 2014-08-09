package me.emmano.wadbce.service;

import android.os.Environment;
import android.os.FileObserver;

import java.io.File;

/**
 * Created by emmanuelortiguela on 8/7/14.
 */
public class WadbceFileObserver extends FileObserver {

    private static final String PATH = Environment.getExternalStorageDirectory() + "/WhatsApp/Databases/";

    private final File databases;

    public WadbceFileObserver() {
        super(PATH);
        databases = new File(PATH);
        deleteFilesInDirectory();
    }

    @Override
    public void onEvent(int flag, String s) {
        deleteDatabaseCopies();
    }

    private void deleteFilesInDirectory() {
        deleteDatabaseCopies();
    }

    private void deleteDatabaseCopies() {
        if (databases.isDirectory()) {
            String[] children = databases.list();
            for (int j = 0; j < children.length; j++) {
                new File(databases, children[j]).delete();
            }
        }
    }
}
