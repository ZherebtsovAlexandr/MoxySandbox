package com.mansonheart.moxysandbox.presentation.presenter.place;


import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlacesView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlacesPresenter extends MvpPresenter<PlacesView> {

    private final Router router;

    public PlacesPresenter(Router router) {
        this.router = router;
    }

    public void onButtonClick() {
        router.navigateTo(Screens.PLACE_DETAIL_SCREEN, 0);
    }

}
