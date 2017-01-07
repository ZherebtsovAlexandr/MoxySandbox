package com.mansonheart.moxysandbox;

import android.app.Application;

import com.mansonheart.moxysandbox.di.app.AppComponent;
import com.mansonheart.moxysandbox.di.app.AppModule;
import com.mansonheart.moxysandbox.di.app.DaggerAppComponent;

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
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}