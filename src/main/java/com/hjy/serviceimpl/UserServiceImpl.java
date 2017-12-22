package com.hjy.serviceimpl;

import com.hjy.dao.UserDao;
import com.hjy.model.User;
import com.hjy.service.UserService;

import javax.annotation.Resource;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public class UserServiceImpl implements UserService {

//    private final UserDao userDao = new UserDaoImpl();
    @Resource
    private UserDao userDao;


    @Override
    public User findUserByUsernamePassword(String username, String password) {
        User user = null;
        user = userDao.selectOneByUsernamePassword(username,password);
        return user;
    }
}
