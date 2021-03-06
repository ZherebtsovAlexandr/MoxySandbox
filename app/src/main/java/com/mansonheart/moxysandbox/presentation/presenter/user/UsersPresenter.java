package com.mansonheart.moxysandbox.presentation.presenter.user;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mansonheart.DefaultObserver;
import com.mansonheart.GetUsers;
import com.mansonheart.User;
import com.mansonheart.moxysandbox.presentation.Screens;
import com.mansonheart.moxysandbox.presentation.view.user.UsersView;

import java.util.List;

import io.reactivex.Observable;
import ru.terrakok.cicerone.Router;

/**
 * Created by Admin on 01.01.2017.
 */
@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    private final Router router;
    private GetUsers getUsers;
    private boolean isFirstTime;

    public UsersPresenter(Router router, GetUsers getUsers) {
        this.getUsers = getUsers;
        this.router = router;
        this.isFirstTime = true;
        getViewState().showInfo("Presenter: " + this.toString());
    }

    public void load(Observable<Integer> offsetObservable) {
        if (isFirstTime) {
            offsetObservable = offsetObservable.startWith(0);
            isFirstTime = false;
        }
        getUsers.execute(new UserListObserver(), GetUsers.Params.forPaging(offsetObservable));
    }

    public void onUserClick(User user) {
        router.navigateTo(Screens.USER_DETAIL_SCREEN, user.getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getUsers.dispose();
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
