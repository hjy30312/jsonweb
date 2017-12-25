package com.hjy.serviceimpl;

import com.hjy.dao.ShopingCartDao;
import com.hjy.daoimpl.ShopingCartDaoImpl;
import com.hjy.model.ShopingCart;
import com.hjy.service.ShopingCartService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class ShopingCartServiceImpl implements ShopingCartService {

    private ShopingCartDao shopingCartDao = new ShopingCartDaoImpl();

    @Override
    public void insertShopingCart(int user_id, int commodity_id) {
        shopingCartDao.insertShopingCart(user_id,commodity_id);
    }

    @Override
    public List<ShopingCart> selectAllByUserID(int user_id) {
        List<ShopingCart> shopingCartList= new ArrayList<ShopingCart>();
        shopingCartList = shopingCartDao.selectAllByUserID(user_id);
        return shopingCartList;
    }

    @Override
    public void deleteOneShoppingCartByid(int id) {
        shopingCartDao.deleteOneShoppingCartByid(id);
    }
}
