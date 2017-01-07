package com.mansonheart.moxysandbox.presentation.presenter.user;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.GetUser;
import com.mansonheart.moxysandbox.model.UserManager;
import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class UserDetailPresenter extends MvpPresenter<UserDetailView> {

    private final GetUser getUser;
    private final UserManager userManager;
    private final String username;
    private final Router router;

    public UserDetailPresenter(String username,
                               GetUser getUser,
                               UserManager userManager,
                               Router router) {
        this.username = username;
        this.getUser = getUser;
        this.userManager = userManager;
        this.router = router;
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
    }

    public void onBackPressed() {
        router.exit();
    }
}
