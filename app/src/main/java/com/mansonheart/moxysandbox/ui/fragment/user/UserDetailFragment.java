package com.mansonheart.moxysandbox.ui.fragment.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.presenter.user.UserDetailPresenter;
import com.mansonheart.moxysandbox.presentation.view.user.UserDetailView;

public class UserDetailFragment extends MvpAppCompatFragment implements UserDetailView {

    public static final String TAG = "UserDetailFragment";
    public static final String USER_NAME_ARG = "UserName";

    public TextView tvName;

    @InjectPresenter
    UserDetailPresenter mUserDetailPresenter;

    public static UserDetailFragment newInstance(String userName) {
        UserDetailFragment fragment = new UserDetailFragment();

        Bundle args = new Bundle();
        args.putString(USER_NAME_ARG, userName);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        String userName = getArguments().getString(USER_NAME_ARG, "Unknown name");
        tvName = (TextView) view.findViewById(R.id.tv_name);
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void showUserName(String userName) {
        tvName.setText(userName);
    }
}
