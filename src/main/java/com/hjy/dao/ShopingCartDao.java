package com.hjy.dao;

import com.hjy.model.ShopingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public interface ShopingCartDao {
    /**
     * 用户添加商品进购物车
     * @param user_id
     * @param commodity_id
     */
    public void insertShopingCart(int user_id,int commodity_id);

    /**
     * 通过用户id找到属于他的购物车
     * @param user_id
     * @return
     */
    public List<ShopingCart> selectAllByUserID(int user_id);
}
