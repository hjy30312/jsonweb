package com.hjy.dao;

import com.hjy.model.ShoppingCart;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public interface ShoppingCartDao {
    /**
     * 用户添加商品进购物车
     * @param user_id
     * @param commodity_id
     */
    public void insertShoppingCart(int user_id,int commodity_id);

    /**
     * 通过用户id找到属于他的购物车
     * @param user_id
     * @return
     */
    public List<ShoppingCart> selectAllByUserID(int user_id);

    /**
     * 通过购物车id删除掉改购物车
     * @param id
     */
    public void deleteOneShoppingCartByid(int id);
}
