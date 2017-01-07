package com.mansonheart.moxysandbox.presentation.presenter.user;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.GetUser;
import com.mansonheart.moxysandbox.model.UserMapper;
import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class UserDetailPresenter extends MvpPresenter<UserDetailView> {

    private final GetUser getUser;
    private final UserMapper userMapper;
    private final String username;
    private final Router router;

    public UserDetailPresenter(String username,
                               GetUser getUser,
                               UserMapper userMapper,
                               Router router) {
        this.username = username;
        this.getUser = getUser;
        this.userMapper = userMapper;
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
