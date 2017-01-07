package com.mansonheart.moxysandbox.di;

import com.mansonheart.moxysandbox.ui.activity.MainActivity;
import com.mansonheart.moxysandbox.ui.fragment.bottom.TabContainerFragment;
import com.mansonheart.moxysandbox.ui.fragment.place.PlaceDetailFragment;

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

    PlaceDetailComponent plus(PlaceDetailsModule placeDetailsModule);

    void inject(MainActivity activity);

    void inject(TabContainerFragment fragment);

    void inject(PlaceDetailFragment fragment);

}
