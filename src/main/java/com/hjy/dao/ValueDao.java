package com.hjy.dao;

import com.hjy.model.Value;

import java.util.List;

/**
 * 价格表数据访问类
 * @author hjy
 * @create 2017/12/21
 **/
public interface ValueDao {
    /**
     * 获取所有价格表的信息
     */
    public List<Value> selectAllValue();


    /**
     * 通过产品编号获取价格表信息
     * @param id
     * @return Value
     */
    public Value selectOneValue(String id);


}
