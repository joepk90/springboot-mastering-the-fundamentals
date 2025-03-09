package com.springbootfundamentals.store;

public interface UserRepository {

    void save(User user);

    Long getUserCount();

}
