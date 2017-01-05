package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.model.UserManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexandr on 04.01.17.
 */

@Module
public class UserDetailModule {

    @FragmentScope
    @Provides
    UserManager provideUserManager() {
        return new UserManager();
    }
}
