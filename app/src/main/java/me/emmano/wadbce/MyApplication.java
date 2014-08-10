package me.emmano.wadbce;

import com.google.inject.Stage;
import com.google.inject.util.Modules;

import android.app.Application;

import me.emmano.wadbce.modules.ApplicationModule;
import roboguice.RoboGuice;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RoboGuice.setBaseApplicationInjector(this, Stage.DEVELOPMENT,
                Modules.combine(RoboGuice.newDefaultRoboModule(this), new ApplicationModule()));
    }
}
