package com.mansonheart.moxysandbox.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 04.01.17.
 */

@Module
public class NavigationModule {

    private final Cicerone<Router> globalRouter;

    public NavigationModule() {
        globalRouter = Cicerone.create();
    }

    @Singleton
    @Provides
    public NavigatorHolder provideNavigatorHolder() {
        return globalRouter.getNavigatorHolder();
    }

    @Singleton
    @Provides
    public Router provideRouter() {
        return globalRouter.getRouter();
    }
}
