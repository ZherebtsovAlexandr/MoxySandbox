package com.mansonheart.moxysandbox.model;

import android.util.Log;

import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.di.PlaceDetailComponent;
import com.mansonheart.moxysandbox.di.PlaceDetailsModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by alexandr on 05.01.17.
 */

public class PlaceManager {

    private PlaceDetailComponent component;
    private List<Integer> placeNumbers = new ArrayList<>();

    @Inject
    public PlaceRepository placeRepository;

    public PlaceManager() {
        createComponent();
        Log.d("Lifecycle", "PlaceManager created:" + this);
    }

    public void addToPlaceNumbers(int number) {
        if (component == null) {
            createComponent();
        }
        placeNumbers.add(number);
    }

    public void removeFromPlaceNumbers(int number) {
        placeNumbers.remove(number);
        if (placeNumbers.size() == 0) {
            releaseComponent();
        }
    }

    private void createComponent() {
        component = App.INSTANCE.getAppComponent().plus(new PlaceDetailsModule());
        component.inject(this);
    }

    private void releaseComponent() {
        component = null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "PlaceManager destroy: " + this);
    }
}
