package com.mansonheart.moxysandbox.model;

import android.util.Log;

import com.mansonheart.Logger;

/**
 * Created by alexandr on 07.01.17.
 */

public class ConsoleLogger implements Logger {
    @Override
    public void log(String tag, String message) {
        Log.d(tag, message);
    }
}
