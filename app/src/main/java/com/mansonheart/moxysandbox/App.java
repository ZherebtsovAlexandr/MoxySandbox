package com.mansonheart.moxysandbox;

import android.app.Application;

import java.util.HashMap;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 02.01.17.
 */

public class App extends Application {

    private Cicerone<Router> globalRouter;
    private HashMap<String, Cicerone<Router>> localRouters;

    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        globalRouter = Cicerone.create();
        localRouters = new HashMap<>();
        INSTANCE = this;
    }

    public NavigatorHolder getNavigatorHolder() {
        return globalRouter.getNavigatorHolder();
    }

    public NavigatorHolder getNavigatorHolderForLocalRouter(String containerTag) {
        return getLocalRouterForTab(containerTag).getNavigatorHolder();
    }

    public Router getGlobalRouter() {
        return globalRouter.getRouter();
    }

    public Cicerone<Router> getLocalRouterForTab(String containerTag) {
        if (!localRouters.containsKey(containerTag)) {
            localRouters.put(containerTag, Cicerone.create());
        }
        return localRouters.get(containerTag);
    }

}