package com.mansonheart.moxysandbox;

import android.app.Application;

import com.mansonheart.moxysandbox.di.AppComponent;
import com.mansonheart.moxysandbox.di.DaggerAppComponent;

/**
 * Created by alexandr on 02.01.17.
 */

public class App extends Application {

    private AppComponent appComponent;
    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        INSTANCE = this;
    }

    public void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}