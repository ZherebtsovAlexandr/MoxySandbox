package com.mansonheart.moxysandbox.ui.fragment.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.di.user.UserDetailPresenterModule;
import com.mansonheart.moxysandbox.presentation.presenter.user.UserDetailPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;
import com.mansonheart.moxysandbox.ui.common.BackButtonListener;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.common.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

public class UserDetailFragment extends BaseFragment implements UserDetailView, BackButtonListener {

    public static final String TAG = "UserDetailFragment";
    public static final String USER_NAME_ARG = "UserName";

    public TextView tvName;

    @Inject
    Provider<UserDetailPresenter> presenterProvider;

    @InjectPresenter
    UserDetailPresenter mUserDetailPresenter;

    @ProvidePresenter
    public UserDetailPresenter createUserDetailPresenter() {
        return presenterProvider.get();
    }


    public static UserDetailFragment newInstance(String userName) {
        UserDetailFragment fragment = new UserDetailFragment();

        Bundle args = new Bundle();
        args.putString(USER_NAME_ARG, userName);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getAppComponent().plus(
                new UserDetailPresenterModule(
                        ((RouterProvider) getParentFragment()).provideRouter(),
                        getArguments().getString(USER_NAME_ARG, "Unknown name"))
        ).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        tvName = (TextView) view.findViewById(R.id.tv_name);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showUserName(String userName) {
        tvName.setText(userName);
    }


    @Override
    public boolean onBackPressed() {
        mUserDetailPresenter.onBackPressed();
        return true;
    }
}
