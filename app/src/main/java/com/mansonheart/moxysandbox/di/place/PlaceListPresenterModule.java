package com.mansonheart.moxysandbox.di.place;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlacesPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * Created by alexandr on 07.01.17.
 */

@Module
public class PlaceListPresenterModule {

    private final Router router;

    public PlaceListPresenterModule(Router router) {
        this.router = router;
    }

    @PresenterScope
    @Provides
    public PlacesPresenter providePlacesPresenter() {
        return new PlacesPresenter(router);
    }

}
