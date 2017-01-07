package com.mansonheart.moxysandbox.di.app;

import android.app.Application;

import com.mansonheart.moxysandbox.model.ConsoleLogger;
import com.mansonheart.Logger;
import com.mansonheart.moxysandbox.model.UserMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexandr on 06.01.17.
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Logger provideLogger() {
        return new ConsoleLogger();
    }

    @Singleton
    @Provides
    UserMapper userMapper(Logger logger) {
        return new UserMapper(logger);
    }
}
