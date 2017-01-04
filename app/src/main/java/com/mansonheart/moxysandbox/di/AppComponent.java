package com.mansonheart.moxysandbox.di;

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
        LocalNavigationModule.class
})
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(TabContainerFragment activity);

}
