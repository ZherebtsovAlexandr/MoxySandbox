package com.mansonheart.moxysandbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mansonheart.User;
import com.mansonheart.moxysandbox.adapterdelegates.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MainActivity extends MvpAppCompatActivity implements UsersView {

    private RecyclerView rvMain;
    private MainAdapter mainAdapter;

    @InjectPresenter
    UsersPresenter usersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMain = (RecyclerView) findViewById(R.id.rv_main);
        rvMain.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(this, new ArrayList<User>());
        rvMain.setAdapter(mainAdapter);
        final Observable<Integer> offsetObservable = ScrollObservable.from(rvMain);
        usersPresenter.load(offsetObservable);
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
    public void showUsers(List<User> users) {
        mainAdapter.addItems(users);
    }
}
