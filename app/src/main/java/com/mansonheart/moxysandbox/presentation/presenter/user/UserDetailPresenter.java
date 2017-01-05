package com.mansonheart.moxysandbox.presentation.presenter.user;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.GetUser;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.di.UserDetailModule;
import com.mansonheart.moxysandbox.model.UserManager;
import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class UserDetailPresenter extends MvpPresenter<UserDetailView> {

    @Inject
    GetUser getUser;

    @Inject
    UserManager userManager;

    private final String username;
    private final Router router;

    public UserDetailPresenter(Router router, String username) {
        App.INSTANCE.createUserDetailComponent().inject(this);
        this.router = router;
        this.username = username;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showUserName(username);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getUser.dispose();
        App.INSTANCE.releaseUserDetailComponent();
    }

    public void onBackPressed() {
        router.exit();
    }
}
