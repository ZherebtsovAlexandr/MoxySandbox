package com.mansonheart.moxysandbox;

import com.arellomobile.mvp.MvpView;
import com.mansonheart.User;

import java.util.List;

/**
 * Created by Admin on 01.01.2017.
 */
public interface UsersView extends MvpView {
    void showUsers(List<User> users);
}
