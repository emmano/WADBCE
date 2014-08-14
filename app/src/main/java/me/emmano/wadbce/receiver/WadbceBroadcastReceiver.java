package me.emmano.wadbce.receiver;

import android.content.Context;
import android.content.Intent;

import me.emmano.wadbce.service.FileWatcherService;
import roboguice.receiver.RoboBroadcastReceiver;

/**
 * Created by emmanuelortiguela on 8/13/14.
 */
public class WadbceBroadcastReceiver extends RoboBroadcastReceiver {

    @Override
    protected void handleReceive(Context context, Intent intent) {
        super.handleReceive(context, intent);
        context.startService(new Intent(context, FileWatcherService.class));
    }
}
