package com.mansonheart.moxysandbox.ui.fragment.place;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.view.place.PlacesView;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlacesPresenter;

import com.arellomobile.mvp.presenter.InjectPresenter;

public class PlacesFragment extends MvpAppCompatFragment implements PlacesView {
    public static final String TAG = "PlacesFragment";
    @InjectPresenter
    PlacesPresenter mPlacesPresenter;

    public static PlacesFragment newInstance() {
        PlacesFragment fragment = new PlacesFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
