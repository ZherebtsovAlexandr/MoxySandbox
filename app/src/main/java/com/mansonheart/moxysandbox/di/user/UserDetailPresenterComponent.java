package com.mansonheart.moxysandbox.di.user;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.ui.fragment.user.UserDetailFragment;

import dagger.Subcomponent;

/**
 * Created by alexandr on 07.01.17.
 */

@PresenterScope
@Subcomponent(modules = UserDetailPresenterModule.class)
public interface UserDetailPresenterComponent {
    void inject(UserDetailFragment fragment);
}
