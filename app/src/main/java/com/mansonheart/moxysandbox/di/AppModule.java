package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.model.PlaceManager;
import com.mansonheart.moxysandbox.model.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexandr on 06.01.17.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    PlaceManager placeManager() {
        return new PlaceManager();
    }

    @Singleton
    @Provides
    UserManager userManager() {
        return new UserManager();
    }
}
