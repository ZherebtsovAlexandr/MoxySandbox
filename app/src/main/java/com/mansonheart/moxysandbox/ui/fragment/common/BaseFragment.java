package com.mansonheart.moxysandbox.ui.fragment.common;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.di.app.AppComponent;

/**
 * Created by alexandr on 07.01.17.
 */

public class BaseFragment extends MvpAppCompatFragment {

    AppComponent appComponent;

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = App.INSTANCE.getAppComponent();
        }
        return this.appComponent;
    }

}
