package com.mansonheart.moxysandbox.presentation.navigation;

import com.mansonheart.moxysandbox.di.LocalNavigationModule;

import java.util.HashMap;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 04.01.17.
 */

public class LocalNavigatorHolder {

    private HashMap<String, Cicerone<Router>> routers;

    public LocalNavigatorHolder() {
        this.routers = new HashMap<>();
    }

    public Cicerone<Router> getRouter(String containerTag) {
        if (!routers.containsKey(containerTag)) {
            routers.put(containerTag, Cicerone.create());
        }
        return routers.get(containerTag);
    }

    public NavigatorHolder getNavigatorHolder(String containerTag) {
        return getRouter(containerTag).getNavigatorHolder();
    }
}
