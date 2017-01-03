package com.mansonheart.moxysandbox.presentation.presenter.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.presentation.Screens;
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
        App.INSTANCE.getGlobalRouter().replaceScreen(Screens.USERS_SCREEN);
        getViewState().highlightTab(MainView.USERS_SCREEN_TAB_POSITION);
    }


    public void onPlacesClick() {
        App.INSTANCE.getGlobalRouter().replaceScreen(Screens.PLACES_SCREEN);
        getViewState().highlightTab(MainView.PLACES_TAB_POSITION);
    }

    public void onFavoritesClick() {
        App.INSTANCE.getGlobalRouter().replaceScreen(Screens.FAVORITES_SCREEN);
        getViewState().highlightTab(MainView.FAVORITES_TAB_POSITION);
    }

    public void onBackPressed() {
        App.INSTANCE.getGlobalRouter().exit();
    }

}