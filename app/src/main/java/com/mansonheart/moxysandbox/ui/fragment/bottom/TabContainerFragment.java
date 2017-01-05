package com.mansonheart.moxysandbox.ui.fragment.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.navigation.LocalNavigatorHolder;
import com.mansonheart.moxysandbox.ui.common.BackButtonListener;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.favorite.FavoritesFragment;
import com.mansonheart.moxysandbox.ui.fragment.place.PlaceDetailFragment;
import com.mansonheart.moxysandbox.ui.fragment.place.PlacesFragment;
import com.mansonheart.moxysandbox.ui.fragment.user.UserDetailFragment;
import com.mansonheart.moxysandbox.ui.fragment.user.UsersFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

/**
 * Created by alexandr on 03.01.17.
 */

public class TabContainerFragment extends Fragment implements RouterProvider, BackButtonListener {

    private static final String EXTRA_NAME = "tcf_extra_name";

    @Inject
    LocalNavigatorHolder localNavigatorHolder;

    private Navigator navigator;

    public static TabContainerFragment newInstance(String name) {
        TabContainerFragment fragment = new TabContainerFragment();

        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_NAME, name);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.INSTANCE.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_container, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getChildFragmentManager().findFragmentById(R.id.ftc_container) == null) {
            switch (getArguments().getString(EXTRA_NAME)) {
                case Screens.USERS_TAB:
                    localNavigatorHolder.getRouter(getArguments().getString(EXTRA_NAME)).getRouter().replaceScreen(Screens.USERS_SCREEN);
                    break;
                case Screens.PLACES_TAB:
                    localNavigatorHolder.getRouter(getArguments().getString(EXTRA_NAME)).getRouter().replaceScreen(Screens.PLACES_SCREEN);
                    break;
                case Screens.FAVORITES_TAB:
                    localNavigatorHolder.getRouter(getArguments().getString(EXTRA_NAME)).getRouter().replaceScreen(Screens.FAVORITES_SCREEN);
                    break;

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        localNavigatorHolder.getNavigatorHolder(getArguments().getString(EXTRA_NAME)).setNavigator(getNavigator());
    }

    @Override
    public void onPause() {
        localNavigatorHolder.getNavigatorHolder(getArguments().getString(EXTRA_NAME)).removeNavigator();
        super.onPause();
    }

    @Override
    public boolean onBackPressed() {
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.ftc_container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return true;
        } else {
            ((RouterProvider) getActivity()).provideRouter().exit();
            return true;
        }
    }

    private Navigator getNavigator() {
        if (navigator == null) {
            navigator = new SupportFragmentNavigator(getChildFragmentManager(),
                    R.id.ftc_container) {
                @Override
                protected Fragment createFragment(String screenKey, Object data) {
                    switch (screenKey) {
                        case Screens.USERS_SCREEN:
                            return UsersFragment.newInstance();
                        case Screens.USER_DETAIL_SCREEN:
                            return UserDetailFragment.newInstance((String) data);
                        case Screens.PLACES_SCREEN:
                            return PlacesFragment.newInstance();
                        case Screens.PLACE_DETAIL_SCREEN:
                            return PlaceDetailFragment.newInstance((Integer) data);
                        case Screens.FAVORITES_SCREEN:
                            return FavoritesFragment.newInstance();
                        default:
                            throw new RuntimeException("Unknow key");
                    }
                }

                @Override
                protected void showSystemMessage(String message) {
                }

                @Override
                protected void exit() {
                    ((RouterProvider) getActivity()).provideRouter().exit();
                }
            };
        }
        return navigator;
    }

    @Override
    public Router provideRouter() {
        return localNavigatorHolder.getRouter(getArguments().getString(EXTRA_NAME)).getRouter();
    }
}
