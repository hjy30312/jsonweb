package com.hjy.service;

import com.hjy.model.ShopingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public interface ShopingCartService {
    public void insertShopingCart(int user_id, int commodity);
    public List<ShopingCart> selectAllByUserID(int user_id);
    public void deleteOneShoppingCartByid(int id);
}
