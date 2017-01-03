package com.mansonheart.moxysandbox.ui.fragment.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.view.favorite.FavoritesView;
import com.mansonheart.moxysandbox.presentation.presenter.favorite.FavoritesPresenter;

import com.arellomobile.mvp.presenter.InjectPresenter;

public class FavoritesFragment extends MvpAppCompatFragment implements FavoritesView {
    public static final String TAG = "FavoritesFragment";
    @InjectPresenter
    FavoritesPresenter mFavoritesPresenter;

    public static FavoritesFragment newInstance() {
        FavoritesFragment fragment = new FavoritesFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
