package com.mansonheart.moxysandbox.di;

import com.mansonheart.GetUser;
import com.mansonheart.moxysandbox.model.UserManager;
import com.mansonheart.moxysandbox.presentation.presenter.user.UserDetailPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 07.01.17.
 */

@Module
public class UserDetailPresenterModule {

    private final Router router;
    private final String userName;

    public UserDetailPresenterModule(Router router, String userName) {
        this.router = router;
        this.userName = userName;
    }

    @PresenterScope
    @Provides
    UserDetailPresenter provideUserDetailPresenter(GetUser getUser, UserManager userManager) {
        return new UserDetailPresenter(userName, getUser, userManager, router);
    }
}
