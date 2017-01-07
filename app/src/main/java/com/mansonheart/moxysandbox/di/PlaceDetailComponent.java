package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.presentation.presenter.place.PlaceDetailPresenter;

import dagger.Subcomponent;

/**
 * Created by alexandr on 06.01.17.
 */

@PlaceDetailScope
@Subcomponent(modules = PlaceDetailsModule.class)
public interface PlaceDetailComponent {
    void inject(PlaceDetailPresenter presenter);
}
