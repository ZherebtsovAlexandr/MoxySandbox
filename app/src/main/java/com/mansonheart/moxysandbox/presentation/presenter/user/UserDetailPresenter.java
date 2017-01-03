package com.mansonheart.moxysandbox.presentation.presenter.user;


import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class UserDetailPresenter extends MvpPresenter<UserDetailView> {

    private final String username;
    private final Router router;

    public UserDetailPresenter(Router router, String username) {
        this.router = router;
        this.username = username;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showUserName(username);
    }

    public void onBackPressed() {
        router.exit();
    }
}
