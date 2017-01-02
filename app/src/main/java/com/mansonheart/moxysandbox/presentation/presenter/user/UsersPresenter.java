package com.mansonheart.moxysandbox.presentation.presenter.user;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.DefaultObserver;
import com.mansonheart.GetUsers;
import com.mansonheart.User;
import com.mansonheart.moxysandbox.App;
import com.mansonheart.moxysandbox.presentation.view.user.UsersView;
import com.mansonheart.moxysandbox.ui.activity.MainActivity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Admin on 01.01.2017.
 */
@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    private GetUsers getUsers;
    private boolean isFirstTime;

    public UsersPresenter() {
        this.getUsers = new GetUsers();
        this.isFirstTime = true;
        getViewState().showTitle("Presenter: " + this.toString());
    }

    public void load(Observable<Integer> offsetObservable) {
        if (isFirstTime) {
            offsetObservable = offsetObservable.startWith(0);
            isFirstTime = false;
        }
        getUsers.execute(new UserListObserver(), GetUsers.Params.forPaging(offsetObservable));
    }

    public void onUserClick(User user) {
        App.INSTANCE.getRouter().navigateTo(MainActivity.USER_DETAIL_SCREEN, user.getName());
    }

    private final class UserListObserver extends DefaultObserver<List<User>> {

        @Override
        public void onComplete() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(List<User> users) {
            getViewState().showUsers(users);
        }
    }
}
