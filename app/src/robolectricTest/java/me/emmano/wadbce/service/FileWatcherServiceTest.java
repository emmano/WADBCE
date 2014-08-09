package me.emmano.wadbce.service;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ServiceController;

import android.app.Service;
import android.content.Intent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class FileWatcherServiceTest {

    @Mock
    private Intent mockIntent;

    @Mock
    private WadbceFileObserver mockFileObserver;

    private ServiceController<FileWatcherService> serviceController;

    @Before
    public void setUp() throws Exception {
        serviceController = Robolectric.buildService(FileWatcherService.class);
    }


    @Test
    public void serviceIsStartedStartSticky() throws Exception {

        final FileWatcherService testObject = serviceController.get();
        assertEquals(Service.START_STICKY,
                testObject.onStartCommand(mockIntent, 1, FileWatcherService.SERVICE_ID));
    }

    @Test
    public void onCreateRegistersFileObserver() throws Exception {

        serviceController.create().get();

        verify(mockFileObserver).startWatching();

    }
}