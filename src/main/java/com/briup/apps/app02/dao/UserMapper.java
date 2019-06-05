package com.briup.apps.app02.dao;

import com.briup.apps.app02.bean.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
    List<User> query(User user);
    User findByPrimaryKey(long id);
    void deleteByPrimaryKey(long id);
    void insert(User user);
    void update(User user);

}
