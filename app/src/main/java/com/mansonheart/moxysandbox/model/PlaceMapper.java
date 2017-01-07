package com.mansonheart.moxysandbox.model;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by alexandr on 06.01.17.
 */

public class PlaceMapper {

    @Inject
    public PlaceMapper() {
        Log.d("Lifecycle", "PlaceMapper created:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "PlaceMapper was collected by GC (" + this + ")");
    }
}
