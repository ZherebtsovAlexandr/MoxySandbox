package com.mansonheart.moxysandbox.ui.fragment.place;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlacesPresenter;
import com.mansonheart.moxysandbox.presentation.view.place.PlacesView;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;

public class PlacesFragment extends MvpAppCompatFragment implements PlacesView {
    public static final String TAG = "PlacesFragment";


    Button btnNext;

    @InjectPresenter
    PlacesPresenter mPlacesPresenter;

    @ProvidePresenter
    PlacesPresenter providePresenter() {
        return new PlacesPresenter(((RouterProvider) getParentFragment()).provideRouter());
    }

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
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlacesPresenter.onButtonClick();
            }
        });
    }
}
