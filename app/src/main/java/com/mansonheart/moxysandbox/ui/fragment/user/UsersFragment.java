package com.mansonheart.moxysandbox.ui.fragment.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.User;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.adapterdelegates.MainAdapter;
import com.mansonheart.moxysandbox.adapterdelegates.UserAdapterDelegate;
import com.mansonheart.moxysandbox.di.user.UserListPresenterModule;
import com.mansonheart.moxysandbox.presentation.presenter.user.UsersPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.UsersView;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.common.BaseFragment;
import com.mansonheart.moxysandbox.ui.util.ScrollObservable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observable;

public class UsersFragment extends BaseFragment implements UsersView, UserAdapterDelegate.OnClickListener {
    public static final String TAG = "UsersFragment";

    private RecyclerView rvMain;
    private TextView tvTitle;
    private MainAdapter mainAdapter;

    @Inject
    Provider<UsersPresenter> presenterProvider;

    @InjectPresenter
    UsersPresenter mUsersPresenter;

    @ProvidePresenter
    UsersPresenter provideUsersPresenter() {
        return presenterProvider.get();
    }

    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getAppComponent().plus(
                new UserListPresenterModule(((RouterProvider) getParentFragment()).provideRouter())
        ).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMain = (RecyclerView) view.findViewById(R.id.rv_main);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        rvMain.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(this.getActivity(),
                MainAdapter.Params.forMainAdapter(new UserAdapterDelegate.Params(this)),
                new ArrayList<User>());
        rvMain.setAdapter(mainAdapter);
        final Observable<Integer> offsetObservable = ScrollObservable.from(rvMain);
        mUsersPresenter.load(offsetObservable);
    }

    @Override
    public void showUsers(List<User> users) {
        mainAdapter.addItems(users);
    }

    @Override
    public void showTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void onClick(User user) {
        mUsersPresenter.onUserClick(user);
    }
}
