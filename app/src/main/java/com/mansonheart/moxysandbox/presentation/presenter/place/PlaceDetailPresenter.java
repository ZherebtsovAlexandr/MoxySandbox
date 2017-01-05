package com.mansonheart.moxysandbox.presentation.presenter.place;


import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlaceDetailPresenter extends MvpPresenter<PlaceDetailView> {

    private final Router router;
    private final int number;

    public PlaceDetailPresenter(int number, Router router) {
        this.router = router;
        this.number = number;
        getViewState().setNumberText(String.valueOf(number));
    }

    public void onNextClick() {
        router.navigateTo(Screens.PLACE_DETAIL_SCREEN, number + 1);
    }

    public void onBackPressed() {
        router.exit();
    }
}
