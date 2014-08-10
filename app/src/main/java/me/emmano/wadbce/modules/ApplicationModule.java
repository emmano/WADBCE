package me.emmano.wadbce.modules;

import com.google.inject.AbstractModule;

import android.support.v4.app.NotificationCompat;

import me.emmano.wadbce.providers.NotificationBuilderProvider;

/**
 * Created by emmanuelortiguela on 8/9/14.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NotificationCompat.Builder.class).toProvider(NotificationBuilderProvider.class);
    }
}
