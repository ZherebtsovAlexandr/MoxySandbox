package com.mansonheart.moxysandbox.di.app;

import com.mansonheart.moxysandbox.di.place.PlaceDetailPresenterComponent;
import com.mansonheart.moxysandbox.di.place.PlaceDetailsPresenterModule;
import com.mansonheart.moxysandbox.di.place.PlaceListPresenterComponent;
import com.mansonheart.moxysandbox.di.place.PlaceListPresenterModule;
import com.mansonheart.moxysandbox.di.user.UserDetailPresenterComponent;
import com.mansonheart.moxysandbox.di.user.UserDetailPresenterModule;
import com.mansonheart.moxysandbox.di.user.UserListPresenterComponent;
import com.mansonheart.moxysandbox.di.user.UserListPresenterModule;
import com.mansonheart.moxysandbox.ui.activity.MainActivity;
import com.mansonheart.moxysandbox.ui.fragment.bottom.TabContainerFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alexandr on 04.01.17.
 */

@Singleton
@Component(modules = {
        NavigationModule.class,
        LocalNavigationModule.class,
        AppModule.class
})
public interface AppComponent {

    UserListPresenterComponent plus(UserListPresenterModule userListPresenterModule);

    UserDetailPresenterComponent plus(UserDetailPresenterModule userDetailPresenterModule);

    PlaceDetailPresenterComponent plus(PlaceDetailsPresenterModule placeDetailsPresenterModule);

    PlaceListPresenterComponent plus(PlaceListPresenterModule placeListPresenterModule);

    void inject(MainActivity activity);

    void inject(TabContainerFragment fragment);

}
