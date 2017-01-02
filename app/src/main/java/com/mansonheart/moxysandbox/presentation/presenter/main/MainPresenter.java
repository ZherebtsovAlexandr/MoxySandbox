package com.mansonheart.moxysandbox.presentation.presenter.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.MainView;

/**
 * Created by alexandr on 02.01.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().openUsers();
    }


}