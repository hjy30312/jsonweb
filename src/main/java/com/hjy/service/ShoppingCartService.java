package com.hjy.service;

import com.hjy.model.ShoppingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public interface ShoppingCartService {
    public void insertShoppingCart(int user_id, int commodity);
    public List<ShoppingCart> selectAllByUserID(int user_id);
    public void deleteOneShoppingCartByid(int id);
}
