package com.mansonheart.moxysandbox.di.user;

import com.mansonheart.GetUsers;
import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.presentation.presenter.user.UsersPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 07.01.17.
 */

@Module
public class UserListPresenterModule {

    private final Router router;

    public UserListPresenterModule(Router router) {
        this.router = router;
    }

    @PresenterScope
    @Provides
    UsersPresenter provideUsersPresenter(GetUsers getUsers) {
        return new UsersPresenter(router, getUsers);
    }

}
