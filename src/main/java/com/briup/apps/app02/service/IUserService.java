package com.briup.apps.app02.service;

import com.briup.apps.app02.bean.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    List<User> query(User user);
    User findById(long id);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(User user) throws Exception;

}
