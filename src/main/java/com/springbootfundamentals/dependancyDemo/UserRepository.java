package com.springbootfundamentals.dependancyDemo;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
