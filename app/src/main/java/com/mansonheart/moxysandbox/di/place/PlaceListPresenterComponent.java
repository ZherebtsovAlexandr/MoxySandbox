package com.mansonheart.moxysandbox.di.place;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.ui.fragment.place.PlacesFragment;

import dagger.Subcomponent;

/**
 * Created by alexandr on 07.01.17.
 */

@PresenterScope
@Subcomponent(modules = PlaceListPresenterModule.class)
public interface PlaceListPresenterComponent {
    void inject(PlacesFragment fragment);
}
