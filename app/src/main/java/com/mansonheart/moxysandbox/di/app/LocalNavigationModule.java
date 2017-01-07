package com.mansonheart.moxysandbox.di.app;

import com.mansonheart.moxysandbox.presentation.navigation.LocalNavigatorHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexandr on 04.01.17.
 */

@Module
public class LocalNavigationModule {

    @Singleton
    @Provides
    public LocalNavigatorHolder provideLocalNavigatorHolder() {
        return new LocalNavigatorHolder();
    }

}
