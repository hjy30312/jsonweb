package com.hjy.service;

import com.hjy.model.User;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public interface UserService {
    public User findUserByUsernamePassword(String username, String Password);
}
