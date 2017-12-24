package com.hjy.dao;

import com.hjy.model.Commodity;

import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public interface CommodityDao {
    public List<Commodity> selectAllCommodity();
}
