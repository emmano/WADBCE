package me.emmano.wadbce.providers;

import com.google.inject.Inject;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

import javax.inject.Provider;

/**
 * Created by emmanuelortiguela on 8/9/14.
 */
public class NotificationBuilderProvider implements Provider<NotificationCompat.Builder> {
    @Inject
    private Context context;

    @Override
    public NotificationCompat.Builder get() {
        return new NotificationCompat.Builder(context);
    }
}
