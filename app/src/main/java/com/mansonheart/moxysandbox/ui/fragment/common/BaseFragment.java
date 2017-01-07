package com.mansonheart.moxysandbox.ui.fragment.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpDelegate;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.di.app.AppComponent;

/**
 * Created by alexandr on 07.01.17.
 */

@SuppressWarnings({"ConstantConditions", "unused"})
public class BaseFragment extends Fragment {

    private AppComponent appComponent;

    private boolean mIsStateSaved;
    private MvpDelegate<BaseFragment> mMvpDelegate;
    private PresenterCallback presenterCallback;

    public void setPresenterCallback(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public interface PresenterCallback {
        void onDestroyPresenter();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMvpDelegate().onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();

        mIsStateSaved = false;

        getMvpDelegate().onAttach();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mIsStateSaved = true;

        getMvpDelegate().onSaveInstanceState(outState);
        getMvpDelegate().onDetach();
    }

    @Override
    public void onStop() {
        super.onStop();

        getMvpDelegate().onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        getMvpDelegate().onDetach();
        getMvpDelegate().onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mIsStateSaved) {
            mIsStateSaved = false;
            return;
        }

        boolean anyParentIsRemoving = false;
        Fragment parent = getParentFragment();
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving();
            parent = parent.getParentFragment();
        }

        if (isRemoving() || anyParentIsRemoving || getActivity().isFinishing()) {
            getMvpDelegate().onDestroy();
            if (presenterCallback != null) {
                presenterCallback.onDestroyPresenter();
            }
        }
    }

    /**
     * @return The {@link MvpDelegate} being used by this Fragment.
     */
    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
        }

        return mMvpDelegate;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = App.INSTANCE.getAppComponent();
        }
        return this.appComponent;
    }
}
