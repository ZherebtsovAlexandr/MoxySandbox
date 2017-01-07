package com.mansonheart.moxysandbox.ui.fragment.place;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.di.place.PlaceListPresenterModule;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlacesPresenter;
import com.mansonheart.moxysandbox.presentation.view.place.PlacesView;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.common.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

public class PlacesFragment extends BaseFragment implements PlacesView {
    public static final String TAG = "PlacesFragment";

    Button btnNext;

    @Inject
    Provider<PlacesPresenter> presenterProvider;

    @InjectPresenter
    PlacesPresenter mPlacesPresenter;

    @ProvidePresenter
    PlacesPresenter providePresenter() {
        return presenterProvider.get();
    }

    public static PlacesFragment newInstance() {
        PlacesFragment fragment = new PlacesFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getAppComponent().plus(
                new PlaceListPresenterModule(((RouterProvider) getParentFragment()).provideRouter())
        ).inject(this);
        super.onCreate(savedInstanceState);
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
