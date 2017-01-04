package com.mansonheart.moxysandbox.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.presenter.main.MainPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.MainView;
import com.mansonheart.moxysandbox.ui.common.BackButtonListener;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.bottom.TabContainerFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;
import ru.terrakok.cicerone.commands.SystemMessage;

public class MainActivity extends MvpAppCompatActivity implements MainView, RouterProvider {

    private TabContainerFragment usersTabFragment;
    private TabContainerFragment placesTabFragment;
    private TabContainerFragment favoritesTabFragment;

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Router router;

    private Navigator navigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if (command instanceof Back) {
                finish();
            } else if (command instanceof SystemMessage) {
                Toast.makeText(MainActivity.this, ((SystemMessage) command).getMessage(), Toast.LENGTH_SHORT).show();
            } else if (command instanceof Replace) {
                FragmentManager fm = getSupportFragmentManager();

                switch (((Replace) command).getScreenKey()) {
                    case Screens.USERS_SCREEN:
                        fm.beginTransaction()
                                .detach(favoritesTabFragment)
                                .detach(placesTabFragment)
                                .attach(usersTabFragment)
                                .commitNow();
                        break;
                    case Screens.PLACES_SCREEN:
                        fm.beginTransaction()
                                .detach(usersTabFragment)
                                .detach(favoritesTabFragment)
                                .attach(placesTabFragment)
                                .commitNow();
                        break;
                    case Screens.FAVORITES_SCREEN:
                        fm.beginTransaction()
                                .detach(usersTabFragment)
                                .detach(placesTabFragment)
                                .attach(favoritesTabFragment)
                                .commitNow();
                        break;
                }
            }
        }
    };
    BottomNavigationView bottomNavigationView;

    @InjectPresenter
    MainPresenter mainPresenter;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return new MainPresenter(router);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.INSTANCE.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_users:
                                mainPresenter.onUsersClick();
                                break;
                            case R.id.action_places:
                                mainPresenter.onPlacesClick();
                                break;
                            case R.id.action_favorites:
                                mainPresenter.onFavoritesClick();
                                break;
                        }
                        return false;
                    }
                });
        initContainers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.master_frame);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            mainPresenter.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void highlightTab(int position) {
    }

    private void initContainers() {
        FragmentManager fm = getSupportFragmentManager();
        usersTabFragment = (TabContainerFragment) fm.findFragmentByTag(Screens.USERS_TAB);
        if (usersTabFragment == null) {
            usersTabFragment = TabContainerFragment.newInstance(Screens.USERS_TAB);
            fm.beginTransaction()
                    .add(R.id.master_frame, usersTabFragment, Screens.USERS_TAB)
                    .detach(usersTabFragment).commitNow();
        }

        placesTabFragment = (TabContainerFragment) fm.findFragmentByTag(Screens.PLACES_TAB);
        if (placesTabFragment == null) {
            placesTabFragment = TabContainerFragment.newInstance(Screens.PLACES_TAB);
            fm.beginTransaction()
                    .add(R.id.master_frame, placesTabFragment, Screens.PLACES_TAB)
                    .detach(placesTabFragment).commitNow();
        }

        favoritesTabFragment = (TabContainerFragment) fm.findFragmentByTag(Screens.FAVORITES_TAB);
        if (favoritesTabFragment == null) {
            favoritesTabFragment = TabContainerFragment.newInstance(Screens.FAVORITES_TAB);
            fm.beginTransaction()
                    .add(R.id.master_frame, favoritesTabFragment, Screens.FAVORITES_TAB)
                    .detach(favoritesTabFragment).commitNow();
        }
    }

    @Override
    public Router provideRouter() {
        return router;
    }
}
