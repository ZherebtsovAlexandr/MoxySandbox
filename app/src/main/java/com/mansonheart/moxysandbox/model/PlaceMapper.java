package com.mansonheart.moxysandbox.model;

import com.mansonheart.Logger;

import javax.inject.Inject;

/**
 * Created by alexandr on 06.01.17.
 */

public class PlaceMapper {

    private final Logger logger;

    @Inject
    public PlaceMapper(Logger logger) {
        this.logger = logger;
        logger.log("Lifecycle", "PlaceMapper created (" + this + ")");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        logger.log("Lifecycle", "PlaceMapper was collected by GC (" + this + ")");
    }
}
