package com.mansonheart.moxysandbox;

import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.GetUsers;
import com.mansonheart.User;

import java.util.List;

/**
 * Created by Admin on 01.01.2017.
 */
public class UsersPresenter extends MvpPresenter<UsersView> {

    private GetUsers getUsers;

    public UsersPresenter(GetUsers getUsers) {
        this.getUsers = getUsers;
    }

    public void init() {
        List<User> users = getUsers.execute(new GetUsers.Params(0, 100));
        getViewState().showUsers(users);
    }
}
