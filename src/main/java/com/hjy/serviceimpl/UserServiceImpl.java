package com.hjy.serviceimpl;

import com.hjy.dao.UserDao;
import com.hjy.daoimpl.UserDaoImpl;
import com.hjy.model.User;
import com.hjy.service.UserService;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    @Override
    public User findUserByUsernamePassword(String username, String password) {
        User user = null;
        user = userDao.selectOneByUsernamePassword(username,password);
        return user;
    }

    @Override
    public void updatePassword(int user_id, String password) {
        userDao.updatePassword(user_id,password);
    }
}
