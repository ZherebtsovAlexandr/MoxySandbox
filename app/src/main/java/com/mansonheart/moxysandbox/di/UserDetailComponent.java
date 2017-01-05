package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.presentation.presenter.user.UserDetailPresenter;

import dagger.Subcomponent;

/**
 * Created by alexandr on 05.01.17.
 */

@PresenterScope
@Subcomponent(
        modules = {
                UserDetailModule.class
        })
public interface UserDetailComponent {
    void inject(UserDetailPresenter presenter);
}
