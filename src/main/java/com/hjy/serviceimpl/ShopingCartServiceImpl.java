package com.hjy.serviceimpl;

import com.hjy.dao.ShopingCartDao;
import com.hjy.daoimpl.ShopingCartDaoImpl;
import com.hjy.service.ShopingCartService;

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
}
