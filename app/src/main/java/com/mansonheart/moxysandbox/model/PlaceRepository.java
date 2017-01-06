package com.mansonheart.moxysandbox.model;

import android.util.Log;

/**
 * Created by alexandr on 06.01.17.
 */

public class PlaceRepository {

    public PlaceRepository() {
        Log.d("Lifecycle", "PlaceRepository created:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "PlaceRepository destroy: " + this);
    }
}
