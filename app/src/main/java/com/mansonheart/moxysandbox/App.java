package com.mansonheart.moxysandbox;

import android.app.Application;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 02.01.17.
 */

public class App extends Application {

    private Cicerone<Router> cicerone;
    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        cicerone = Cicerone.create();
        INSTANCE = this;
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }

}