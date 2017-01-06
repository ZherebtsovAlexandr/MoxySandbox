package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.model.PlaceManager;

import dagger.Subcomponent;

/**
 * Created by alexandr on 06.01.17.
 */

@PlaceDetailScope
@Subcomponent(modules = PlaceDetailsModule.class)
public interface PlaceDetailComponent {
    void inject(PlaceManager placeManager);
}
