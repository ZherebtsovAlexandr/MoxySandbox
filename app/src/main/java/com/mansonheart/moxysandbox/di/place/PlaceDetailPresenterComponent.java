package com.mansonheart.moxysandbox.di.place;

import com.mansonheart.moxysandbox.di.PresenterScope;
import com.mansonheart.moxysandbox.ui.fragment.place.PlaceDetailFragment;

import dagger.Subcomponent;

/**
 * Created by alexandr on 06.01.17.
 */

@PresenterScope
@Subcomponent(modules = PlaceDetailsPresenterModule.class)
public interface PlaceDetailPresenterComponent {
    void inject(PlaceDetailFragment fragment);
}
