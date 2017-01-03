package com.mansonheart.moxysandbox.presentation.presenter.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.presentation.view.user.MainView;

/**
 * Created by alexandr on 02.01.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        onUsersClick();
    }

    public void onUsersClick() {
        App.INSTANCE.getRouter().replaceScreen(MainView.USERS_SCREEN);
        getViewState().highlightTab(MainView.USERS_SCREEN_TAB_POSITION);
    }


    public void onPlacesClick() {
        App.INSTANCE.getRouter().replaceScreen(MainView.PLACES_SCREEN);
        getViewState().highlightTab(MainView.PLACES_TAB_POSITION);
    }

    public void onFavoritesClick() {
        App.INSTANCE.getRouter().replaceScreen(MainView.FAVORITES_SCREEN);
        getViewState().highlightTab(MainView.FAVORITES_TAB_POSITION);
    }


}