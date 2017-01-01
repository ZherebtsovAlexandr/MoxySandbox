package com.mansonheart;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class GetUsers extends UseCase<List<User>, GetUsers.Params> {

    private final int LIMIT = 20;

    @Override
    Observable<List<User>> buildUseCaseObservable(Params params) {
        return params.offsetObservable
                .distinctUntilChanged()
                .flatMap(new Function<Integer, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(Integer integer) throws Exception {
                        List<User> users = new ArrayList<>();
                        for (int i = integer; i < integer + LIMIT; i++) {
                            User user = new User(i, "User #" + i);
                            users.add(user);
                        }
                        return Observable.just(users);
                    }
                });
    }

    public static final class Params {

        private final Observable<Integer> offsetObservable;

        public Params(Observable<Integer> offsetObservable) {
            this.offsetObservable = offsetObservable;
        }

        public static Params forPaging(Observable<Integer> offsetObservable) {
            return new Params(offsetObservable);
        }
    }

}
