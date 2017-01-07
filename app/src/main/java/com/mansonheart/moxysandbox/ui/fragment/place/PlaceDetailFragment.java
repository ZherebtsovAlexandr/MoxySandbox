package com.mansonheart.moxysandbox.ui.fragment.place;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.di.place.PlaceDetailsPresenterModule;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlaceDetailPresenter;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;
import com.mansonheart.moxysandbox.ui.common.BackButtonListener;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;
import com.mansonheart.moxysandbox.ui.fragment.common.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

public class PlaceDetailFragment extends BaseFragment implements PlaceDetailView, BackButtonListener {
    public static final String TAG = "PlaceDetailFragment";
    private static final String EXTRA_NUMBER = "extra_number";

    Toolbar toolbar;
    Button btnNext;

    @Inject
    Provider<PlaceDetailPresenter> provider;

    @InjectPresenter
    PlaceDetailPresenter mPlaceDetailPresenter;

    @ProvidePresenter
    PlaceDetailPresenter providePlaceDetailPresenter() {
        return provider.get();
    }

    public static PlaceDetailFragment newInstance(int number) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();

        Bundle args = new Bundle();
        args.putInt(EXTRA_NUMBER, number);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Lifecycle", "PlaceDetailFragment create: " + this);
        getAppComponent().plus(
                new PlaceDetailsPresenterModule(
                        getArguments().getInt(EXTRA_NUMBER),
                        ((RouterProvider) getParentFragment()).provideRouter()
                )
        ).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_detail, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlaceDetailPresenter.onNextClick();
            }
        });
    }

    @Override
    public void setNumberText(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public boolean onBackPressed() {
        mPlaceDetailPresenter.onBackPressed();
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("Lifecycle", "PlaceDetailFragment destroy: " + this);
    }

}
