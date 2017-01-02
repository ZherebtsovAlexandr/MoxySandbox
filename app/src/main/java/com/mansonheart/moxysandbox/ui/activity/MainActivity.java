package com.mansonheart.moxysandbox.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.presenter.main.MainPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.MainView;
import com.mansonheart.moxysandbox.ui.fragment.user.UserDetailFragment;
import com.mansonheart.moxysandbox.ui.fragment.user.UsersFragment;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private final String USERS_SCREEN = "users_screen";
    private final String USER_DETAIL_SCREEN = "user_detail_screen";

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),
            R.id.master_frame) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case USERS_SCREEN:
                    return UsersFragment.newInstance();
                case USER_DETAIL_SCREEN:
                    return UserDetailFragment.newInstance((String) data);
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };


    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.INSTANCE.getNavigatorHolder().removeNavigator();
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
    public void openUsers() {
        App.INSTANCE.getRouter().navigateTo(USERS_SCREEN);
    }
}
