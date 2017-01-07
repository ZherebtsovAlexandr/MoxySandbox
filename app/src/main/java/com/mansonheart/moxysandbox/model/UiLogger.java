package com.mansonheart.moxysandbox.model;

import android.content.Context;
import android.widget.Toast;

import com.mansonheart.Logger;

/**
 * Created by alexandr on 07.01.17.
 */

public class UiLogger implements Logger {

    private final Context context;

    public UiLogger(Context context) {
        this.context = context;
    }

    @Override
    public void log(String tag, String message) {
        Toast.makeText(context, String.format("%s: %s", tag, message), Toast.LENGTH_SHORT).show();
    }
}
