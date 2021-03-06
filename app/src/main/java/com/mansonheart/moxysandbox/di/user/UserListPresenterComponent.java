package com.mansonheart.moxysandbox.di.user;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.ui.fragment.user.UsersFragment;

import dagger.Subcomponent;

/**
 * Created by alexandr on 07.01.17.
 */

@PresenterScope
@Subcomponent(modules = UserListPresenterModule.class)
public interface UserListPresenterComponent {
    void inject(UsersFragment fragment);
}
