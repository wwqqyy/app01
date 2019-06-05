package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll()
    {
    return userMapper.findAll();
}

    @Override
    public User findById(long id){

        return userMapper.findByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) throws Exception{
        User user=userMapper.findByPrimaryKey(id);

        if(user==null){
            throw new Exception("no user");
        }
        else {
            userMapper.deleteByPrimaryKey(id);
        }
        }

    @Override
    public List<User> query(User user) {
        return userMapper.query(user);
    }

    @Override
    public void saveOrUpdate(User user) throws Exception {
        if(user.getId()==null){
            user.setStatus("normal");
            userMapper.insert(user);
        }
        else{
            userMapper.update(user);
        }
    }
}
