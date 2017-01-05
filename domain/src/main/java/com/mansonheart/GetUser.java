package com.mansonheart;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by alexandr on 04.01.17.
 */

public class GetUser extends UseCase<User, GetUser.Params> {

    @Inject
    public GetUser() {
        System.out.println("Dagger: GetUser created");
    }

    @Override
    Observable<User> buildUseCaseObservable(Params params) {
        return Observable.just(new User(params.id, "User #" + params.id));
    }

    public static final class Params {

        private final Integer id;

        public Params(Integer id) {
            this.id = id;
        }

        public static GetUser.Params forUser(int id) {
            return new GetUser.Params(id);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dagger: GetUser destroy");
    }
}
