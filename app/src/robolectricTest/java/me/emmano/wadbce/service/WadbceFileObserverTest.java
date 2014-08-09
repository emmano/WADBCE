package me.emmano.wadbce.service;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import android.os.Environment;

import java.io.File;

import static org.junit.Assert.assertEquals;

@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class WadbceFileObserverTest {


    private static final String PATH = Environment.getExternalStorageDirectory()
            + "/WhatsApp/Databases/";

    private final WadbceFileObserver testObeject = new WadbceFileObserver();

    @Test
    public void removesFileWhenAlreadyOnDatabaseFolder() throws Exception {
        final File testFile = new File(PATH + "test.txt");
        testFile.mkdirs();

        assertEquals(0, testFile.getParentFile().list().length);
    }

    @Test
    public void removesFileWhenAddedToDatabaseFolder() throws Exception {
        final File testFile1 = new File(PATH + "test1.txt");
        testFile1.mkdirs();

        testObeject.startWatching();

        assertEquals(0, testFile1.getParentFile().list().length);
    }
}