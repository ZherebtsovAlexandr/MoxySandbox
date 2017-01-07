package com.mansonheart.moxysandbox.presentation.presenter.place;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.moxysandbox.model.PlaceMapper;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlaceDetailPresenter extends MvpPresenter<PlaceDetailView> {

    private final Router router;
    private final int number;

    public PlaceDetailPresenter(int number,
                                Router router,
                                PlaceMapper placeMapper) {
        Log.d("Lifecycle", "PlaceDetailPresenter created:" + this);
        this.router = router;
        this.number = number;
        getViewState().setNumberText("Place number " + String.valueOf(number));
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
        Log.d("Lifecycle", "PlaceDetailPresenter destroy:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "PlaceDetailPresenter was collected by GC (" + this + ")");
    }
}
