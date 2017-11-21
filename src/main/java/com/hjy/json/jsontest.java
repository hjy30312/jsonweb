package com.hjy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author hjy
 * @create 2017/11/20
 **/
public class jsontest {

    public static void main(String[] args) throws IOException {
        File file =
                new File((jsontest.class.getResource("/student.json").getFile()));
        String content = FileUtils.readFileToString(file);
        JSONObject jsonObject = JSON.parseObject(content);
        System.out.println(jsonObject.toJSONString());
        System.out.println("name:" + jsonObject.getString("name"));
    }
}
