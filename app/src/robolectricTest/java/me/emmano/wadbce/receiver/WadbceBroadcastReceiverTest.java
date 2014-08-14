package me.emmano.wadbce.receiver;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import android.content.Intent;

import java.util.List;

import me.emmano.wadbce.service.FileWatcherService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class WadbceBroadcastReceiverTest {

    @Test
    public void receiverIsRegisteredCorrectly() throws Exception {

        final List<ShadowApplication.Wrapper> registeredReceivers = Robolectric
                .getShadowApplication().getRegisteredReceivers();

        assertFalse(registeredReceivers.isEmpty());
    }

    @Test
    public void broadcastIsReceivedByReceiverAndStartsService() throws Exception {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.BOOT_COMPLETED");
        final ShadowApplication shadowApplication = Robolectric.getShadowApplication();
        shadowApplication.sendBroadcast(intent);

        assertEquals(FileWatcherService.class.getCanonicalName(),shadowApplication.getNextStartedService().getComponent().getClassName());

    }
}