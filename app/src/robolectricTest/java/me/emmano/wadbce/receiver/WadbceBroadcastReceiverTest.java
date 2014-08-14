package me.emmano.wadbce.receiver;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.util.List;

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
    public void broadcastIsReceivedByReceiver() throws Exception {

        Robolectric.getShadowApplication().send

    }
}