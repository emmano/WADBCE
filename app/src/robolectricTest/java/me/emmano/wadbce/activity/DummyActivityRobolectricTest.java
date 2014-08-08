package me.emmano.wadbce.activity;

import com.jeskeshouse.injectedtestrunner.InjectedTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import android.app.Activity;
import android.content.Intent;

import me.emmano.wadbce.service.FileWatcherService;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Robolectric.shadowOf;

@Config(emulateSdk = 18)
@RunWith(InjectedTestRunner.class)
public class DummyActivityRobolectricTest {

    private Activity testObject;

    @Before
    public void setUp() throws Exception {
        testObject = Robolectric.buildActivity(DummyActivity.class).create().get();
    }

    @Test
    public void onCreateStartsServiceAndFinishesActivity() throws Exception {
        final ShadowActivity shadowActivity = shadowOf(testObject);
        final Intent nextStartedServiceIntent = shadowActivity.getNextStartedService();

        assertNotNull(nextStartedServiceIntent);
        assertEquals(FileWatcherService.class.getCanonicalName(), nextStartedServiceIntent.getComponent().getClassName());
        assertTrue(testObject.isFinishing());
    }


}
