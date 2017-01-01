package com.mansonheart;

import java.util.ArrayList;
import java.util.List;

public class GetUsers {

    public List<User> execute(Params params) {
        List<User> users = new ArrayList<>();
        for (int i = params.offset; i < params.offset + params.limit; i++) {
            User user = new User(i, "User #" + i);
            users.add(user);
        }
        return users;
    }

    public static final class Params {

        private final int offset;
        private final int limit;

        public Params(int offset, int limit) {
            this.offset = offset;
            this.limit = limit;
        }

        public static Params forPaging(int offset, int limit) {
            return new Params(offset, limit);
        }
    }

}
