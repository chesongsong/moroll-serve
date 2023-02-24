package com.moroll.server.utils;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.moroll.server.entity.SysDept;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 15:45
 */
public class ObjectUtil {
    /**
     * 获取 Class 上的字段，并转化成hasMap
     * @param object
     * @param <T>
     * @return
     */
    public static  <T> Map<String, Object> entityToMap(T object) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("serialVersionUID")) { // 排除 serialVersionUID 属性
                field.setAccessible(true);
                try {
                    // 驼峰转下划线
                    String databaseFieldName = StringUtils.camelToUnderline(field.getName());
                    if(field.get(object)!=null){
                        map.put(databaseFieldName, field.get(object));
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


  public static <T> QueryWrapper<T>  getListQuery(T data){
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        if(data!=null){
            Map<String,Object> params = ObjectUtil.entityToMap(data);
            queryWrapper.allEq(params,false);
        }
        return  queryWrapper;
    }

}