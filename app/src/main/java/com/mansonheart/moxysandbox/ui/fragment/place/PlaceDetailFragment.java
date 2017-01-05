package com.mansonheart.moxysandbox.ui.fragment.place;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mansonheart.moxysandbox.R;
import com.mansonheart.moxysandbox.presentation.view.place.PlaceDetailView;
import com.mansonheart.moxysandbox.presentation.presenter.place.PlaceDetailPresenter;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mansonheart.moxysandbox.ui.common.BackButtonListener;
import com.mansonheart.moxysandbox.ui.common.RouterProvider;

public class PlaceDetailFragment extends MvpAppCompatFragment implements PlaceDetailView, BackButtonListener {
    public static final String TAG = "PlaceDetailFragment";
    private static final String EXTRA_NUMBER = "extra_number";

    TextView tvNumberText;
    Button btnNext;

    @InjectPresenter
    PlaceDetailPresenter mPlaceDetailPresenter;

    @ProvidePresenter
    PlaceDetailPresenter providePlaceDetailPresenter() {
        return new PlaceDetailPresenter(getArguments().getInt(EXTRA_NUMBER), ((RouterProvider) getParentFragment()).provideRouter());
    }

    public static PlaceDetailFragment newInstance(int number) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();

        Bundle args = new Bundle();
        args.putInt(EXTRA_NUMBER, number);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_detail, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNumberText = (TextView) view.findViewById(R.id.tv_text);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlaceDetailPresenter.onNextClick();
            }
        });
    }

    @Override
    public void setNumberText(String chainText) {
        tvNumberText.setText(chainText);
    }

    @Override
    public boolean onBackPressed() {
        mPlaceDetailPresenter.onBackPressed();
        return true;
    }

}
