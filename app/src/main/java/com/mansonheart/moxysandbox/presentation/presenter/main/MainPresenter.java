package com.mansonheart.moxysandbox.presentation.presenter.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.user.MainView;

import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 02.01.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router router;

    public MainPresenter(Router router){
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        onUsersClick();
    }

    public void onUsersClick() {
        router.replaceScreen(Screens.USERS_SCREEN);
        getViewState().highlightTab(MainView.USERS_SCREEN_TAB_POSITION);
    }


    public void onPlacesClick() {
        router.replaceScreen(Screens.PLACES_SCREEN);
        getViewState().highlightTab(MainView.PLACES_TAB_POSITION);
    }

    public void onFavoritesClick() {
        router.replaceScreen(Screens.FAVORITES_SCREEN);
        getViewState().highlightTab(MainView.FAVORITES_TAB_POSITION);
    }

    public void onBackPressed() {
        router.exit();
    }

}