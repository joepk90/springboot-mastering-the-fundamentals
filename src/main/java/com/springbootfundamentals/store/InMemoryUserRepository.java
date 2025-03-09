package com.springbootfundamentals.store;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> userStorage = new HashMap<>();

    @Override
    public void save(User user) {
        userStorage.put(user.getEmail(), user);
    }

    public Long getUserCount() {
        return (long) userStorage.size();
    }
}
