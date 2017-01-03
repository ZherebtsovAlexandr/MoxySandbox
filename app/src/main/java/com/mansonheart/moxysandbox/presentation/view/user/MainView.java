package com.mansonheart.moxysandbox.presentation.view.user;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by alexandr on 02.01.17.
 */

public interface MainView extends MvpView {

    String USERS_SCREEN = "users_screen";
    String PLACES_SCREEN = "places_screen";
    String FAVORITES_SCREEN = "favorites_screen";
    String USER_DETAIL_SCREEN = "user_detail_screen";

    int USERS_SCREEN_TAB_POSITION = 0;
    int PLACES_TAB_POSITION = 1;
    int FAVORITES_TAB_POSITION = 2;

    @StateStrategyType(AddToEndSingleStrategy.class)
    void highlightTab(int position);
}
