package me.emmano.wadbce.notification;

import com.google.inject.Inject;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import me.emmano.wadbce.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class NotificationDispatcherTest {

    @Mock
    private NotificationManager mockNotificationManager;

    @Mock
    private NotificationCompat.Builder mockBuilder;

    @Inject
    private NotificationDispatcher testObject;

    @Test
    public void dispatchNotification_SetsTitleAndContentCorrectlyAndNotifies() throws Exception {

        final int expectedContentTextId = R.string.removed_databases_text;
        when(mockBuilder.setSmallIcon(anyInt())).thenReturn(mockBuilder);
        when(mockBuilder.setContentText(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.setContentTitle(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(Notification.class));

        testObject.dispatch(expectedContentTextId);

        verify(mockBuilder).setSmallIcon(R.drawable.wadbce_icon);
        verify(mockBuilder).setContentText(Robolectric.application.getString(expectedContentTextId));
        verify(mockBuilder).setContentTitle(Robolectric.application.getString(R.string.app_name));
        verify(mockNotificationManager)
                .notify(eq(NotificationDispatcher.ID), isA(Notification.class));
    }
}