package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.model.PlaceRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexandr on 05.01.17.
 */

@Module
public class PlaceDetailsModule {

    @PlaceDetailScope
    @Provides
    public PlaceRepository placeRepository() {
        return new PlaceRepository();
    }

}
