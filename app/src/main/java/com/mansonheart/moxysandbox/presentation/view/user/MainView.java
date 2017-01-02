package com.mansonheart.moxysandbox.presentation.view.user;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by alexandr on 02.01.17.
 */

public interface MainView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void openUsers();
}
