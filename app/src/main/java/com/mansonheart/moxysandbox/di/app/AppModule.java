package com.mansonheart.moxysandbox.di.app;

import com.mansonheart.moxysandbox.model.UserMapper;

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
    UserMapper userMapper() {
        return new UserMapper();
    }
}
