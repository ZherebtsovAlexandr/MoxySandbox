package com.mansonheart.moxysandbox.presentation.presenter.place;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.Logger;
import com.mansonheart.moxysandbox.model.PlaceMapper;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PlaceDetailPresenter extends MvpPresenter<PlaceDetailView> {

    private final Router router;
    private final int number;
    private final Logger logger;

    public PlaceDetailPresenter(int number,
                                Router router,
                                PlaceMapper placeMapper,
                                Logger logger) {
        this.logger = logger;
        this.router = router;
        this.number = number;
        getViewState().setNumberText("Place number " + String.valueOf(number));

        logger.log("Lifecycle", "PlaceDetailPresenter created (" + this + ")");
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
        logger.log("Lifecycle", "PlaceDetailPresenter destroy:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        logger.log("Lifecycle", "PlaceDetailPresenter was collected by GC (" + this + ")");
    }
}
