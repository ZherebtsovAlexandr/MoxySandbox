package com.mansonheart.moxysandbox.model;

import com.mansonheart.Logger;

/**
 * Created by alexandr on 05.01.17.
 */

public class UserMapper {

    private final Logger logger;

    public UserMapper(Logger logger) {
        this.logger = logger;
        logger.log("Lifecycle", "UserMapper created (" + this + ")");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        logger.log("Lifecycle", "UserMapper was collected by GC (" + this + ")");
    }
}
