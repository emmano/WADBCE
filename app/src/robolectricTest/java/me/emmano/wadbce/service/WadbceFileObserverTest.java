package me.emmano.wadbce.service;

import com.google.inject.Inject;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v4.app.NotificationCompat;

import java.io.File;

import me.emmano.wadbce.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class WadbceFileObserverTest {

    @Mock
    NotificationCompat.Builder mockNotificationBuilder;

    @Mock
    NotificationManager mockManager;

    private final String PATH = Environment.getExternalStorageDirectory()
            + "/WhatsApp/Databases/";

    @Inject
    private WadbceFileObserver testObject;

    @Test
    public void displaysNotificationWhenFileIsDeleted() throws Exception {
        when(mockManager.toString()).thenReturn("MOCK FROM TEST");
        when(mockNotificationBuilder.build()).thenReturn(isA(Notification.class));
        when(mockNotificationBuilder.setSmallIcon(R.drawable.ic_launcher)).thenReturn(mockNotificationBuilder);
        when(mockNotificationBuilder.setContentText("WADBCE removed files")).thenReturn(mockNotificationBuilder);
        when(mockNotificationBuilder.setContentTitle("WADBCE")).thenReturn(mockNotificationBuilder);

        final File testFile = new File(PATH + "test1.txt");
        testFile.mkdirs();

        testObject.deleteFilesInDirectory();

        verify(mockNotificationBuilder).build();
        verify(mockManager).notify(eq(WadbceFileObserver.NOTIFICATION_ID), isA(Notification.class));

    }
}