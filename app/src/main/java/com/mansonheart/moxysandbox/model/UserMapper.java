package com.mansonheart.moxysandbox.model;

import android.util.Log;

/**
 * Created by alexandr on 05.01.17.
 */

public class UserMapper {

    public UserMapper() {
        Log.d("Lifecycle", "UserMapper created (" + this + ")");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "UserMapper was collected by GC (" + this + ")");
    }
}
