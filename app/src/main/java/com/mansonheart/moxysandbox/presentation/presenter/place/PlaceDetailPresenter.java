package com.mansonheart.moxysandbox.presentation.presenter.place;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.model.PlaceManager;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlaceDetailPresenter extends MvpPresenter<PlaceDetailView> {

    @Inject
    PlaceManager placeManager;

    private final Router router;
    private final int number;

    public PlaceDetailPresenter(int number, Router router) {
        Log.d("Lifecycle", "PlaceDetailPresenter created:" + this);
        App.INSTANCE.getAppComponent().inject(this);
        placeManager.addToPlaceNumbers(number);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        placeManager.removeFromPlaceNumbers(number);
        Log.d("Lifecycle", "PlaceDetailPresenter destroy:" + this);
    }
}
