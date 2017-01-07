package com.mansonheart.moxysandbox.di.place;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.model.PlaceMapper;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlaceDetailPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 05.01.17.
 */

@Module
public class PlaceDetailsPresenterModule {


    private final int number;
    private final Router router;

    public PlaceDetailsPresenterModule(int number,
                                       Router router) {
        this.number = number;
        this.router = router;
    }

    @PresenterScope
    @Provides
    public PlaceDetailPresenter providePlaceDetailPresenter(PlaceMapper placeMapper) {
        return new PlaceDetailPresenter(number, router, placeMapper);
    }

}
