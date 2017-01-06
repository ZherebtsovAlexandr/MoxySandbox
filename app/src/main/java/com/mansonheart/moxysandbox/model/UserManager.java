package com.mansonheart.moxysandbox.model;

import android.util.Log;

/**
 * Created by alexandr on 05.01.17.
 */

public class UserManager {

    public UserManager() {
        Log.d("Lifecycle", "UserManager created:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "UserManager destroy: " + this);
    }
}
