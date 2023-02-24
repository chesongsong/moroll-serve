package com.moroll.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moroll.server.entity.SysDept;
import com.moroll.server.mapper.SysDeptMapper;
import com.moroll.server.service.SysDeptService;
import com.moroll.server.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 14:58
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Autowired
    SysDeptMapper deptMapper;

    /**
     * 判断部门名称是否唯一
     * @param dept
     * @return
     */
    @Override
    public Boolean isUnique(SysDept dept) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        if(dept.getParentId()!=null){
            queryWrapper.eq("parentId",dept.getParentId());
        }
        queryWrapper.eq("name",dept.getName());
        SysDept sysDept = deptMapper.selectOne(queryWrapper);
        return sysDept==null;
    }

    @Override
    public List<SysDept> listDept(SysDept dept) {
        // 条件查询部门列表
        QueryWrapper<SysDept> queryWrapper = ObjectUtil.getListQuery(dept);
        return deptMapper.selectList(queryWrapper);
    }
}