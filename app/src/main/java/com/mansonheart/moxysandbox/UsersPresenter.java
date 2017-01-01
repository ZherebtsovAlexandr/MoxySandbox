package com.mansonheart.moxysandbox;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.DefaultObserver;
import com.mansonheart.GetUsers;
import com.mansonheart.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Admin on 01.01.2017.
 */
@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    private GetUsers getUsers;

    public UsersPresenter() {
        this.getUsers = new GetUsers();
    }

    public void load(Observable<Integer> offsetObservable) {
        Observable<Integer> offsetObservableWithInit = offsetObservable.startWith(0);
        getUsers.execute(new UserListObserver(), GetUsers.Params.forPaging(offsetObservableWithInit));
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
