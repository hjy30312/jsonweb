package com.hjy.service;

import com.hjy.model.User;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public interface UserService {
    public User findUserByUsernamePassword(String username, String Password);
    public void updatePassword(int user_id, String oldPassword, String password);
}
