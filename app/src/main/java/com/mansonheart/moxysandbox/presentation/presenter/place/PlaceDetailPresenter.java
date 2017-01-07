package com.mansonheart.moxysandbox.presentation.presenter.place;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.model.PlaceManager;
import com.mansonheart.moxysandbox.model.PlaceRepository;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlaceDetailPresenter extends MvpPresenter<PlaceDetailView> {

    @Inject
    PlaceRepository placeRepository;

    private final Router router;
    private final int number;
    private final PlaceManager placeManager;

    public PlaceDetailPresenter(int number, Router router, PlaceManager placeManager) {
        Log.d("Lifecycle", "PlaceDetailPresenter created:" + this);
        this.placeManager = placeManager;
        this.router = router;
        this.number = number;
        placeManager.getPlaceComponent().inject(this);
        placeManager.addToPlaceNumbers(number);
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
