package com.hjy.dao;

import com.hjy.model.User;

/**
 * @author hjy
 * @create 2017/12/10
 **/
public interface UserDao {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User selectOneByUsernamePassword(String username, String password);

    public void updatePassword(int id, String password);
}
