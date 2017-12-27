package com.hjy.serviceimpl;

import com.hjy.dao.ShoppingCartDao;
import com.hjy.daoimpl.ShoppingCartDaoImpl;
import com.hjy.model.ShoppingCart;
import com.hjy.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();

    @Override
    public void insertShoppingCart(int user_id, int commodity_id, double value) {
        shoppingCartDao.insertShoppingCart(user_id,commodity_id,value);
    }

    @Override
    public List<ShoppingCart> selectAllByUserID(int user_id) {
        List<ShoppingCart> shoppingCartList= new ArrayList<ShoppingCart>();
        shoppingCartList = shoppingCartDao.selectAllByUserID(user_id);
        return shoppingCartList;
    }

    @Override
    public void deleteOneShoppingCartById(int id) {
        shoppingCartDao.deleteOneShoppingCartById(id);
    }
}
