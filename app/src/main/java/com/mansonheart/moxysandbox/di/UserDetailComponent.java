package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.presentation.presenter.user.UserDetailPresenter;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by alexandr on 05.01.17.
 */

@FragmentScope
@Subcomponent(
        modules = {
                UserDetailModule.class
        })
public interface UserDetailComponent {
    void inject(UserDetailPresenter presenter);
}
