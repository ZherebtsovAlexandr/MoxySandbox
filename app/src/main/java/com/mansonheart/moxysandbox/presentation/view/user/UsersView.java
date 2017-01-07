package com.mansonheart.moxysandbox.presentation.view.user;

import com.arellomobile.mvp.MvpView;
import com.mansonheart.User;

import java.util.List;

/**
 * Created by Admin on 01.01.2017.
 */
public interface UsersView extends MvpView {
    void showUsers(List<User> users);

    void showInfo(String info);

}
