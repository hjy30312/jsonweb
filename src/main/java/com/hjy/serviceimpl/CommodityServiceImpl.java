package com.hjy.serviceimpl;

import com.hjy.dao.CommodityDao;
import com.hjy.daoimpl.CommodityDaoImpl;
import com.hjy.model.Commodity;
import com.hjy.service.CommodityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hjy
 * @create 2017/12/24
 **/
public class CommodityServiceImpl implements CommodityService {

    private CommodityDao commodityDao = new CommodityDaoImpl();
    @Override
    public List<Commodity> findAllCommodity() {
        List<Commodity> commodityList = null;
        commodityList = commodityDao.selectAllCommodity();
        return commodityList;
    }
}
