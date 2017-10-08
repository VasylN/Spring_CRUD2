package com.crud.dao;

import com.crud.model.User;

import java.util.List;

/**
 * Created by Pc on 24.09.2017.
 */
public interface UserRepository {
    void addUser(User user);

    User get(Integer id);

    List<User> getAll();

    void removeUser(Integer id);

    void updateUser(User user);
}
