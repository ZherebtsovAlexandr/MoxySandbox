package com.mansonheart.moxysandbox;

import android.app.Application;

import com.mansonheart.moxysandbox.di.AppComponent;
import com.mansonheart.moxysandbox.di.DaggerAppComponent;
import com.mansonheart.moxysandbox.di.UserDetailComponent;
import com.mansonheart.moxysandbox.di.UserDetailModule;

/**
 * Created by alexandr on 02.01.17.
 */

public class App extends Application {

    private AppComponent appComponent;
    private UserDetailComponent userDetailComponent;

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

    public UserDetailComponent createUserDetailComponent() {
        userDetailComponent = appComponent.plus(new UserDetailModule());
        return userDetailComponent;
    }

    public void releaseUserDetailComponent() {
        userDetailComponent = null;
    }


}