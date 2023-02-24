package com.moroll.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moroll.server.entity.SysDept;
import com.moroll.server.entity.SysRole;
import com.moroll.server.mapper.SysRoleMapper;
import com.moroll.server.service.SysRoleService;
import com.moroll.server.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 17:34
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    SysRoleMapper roleMapper;

    @Override
    public Boolean isUnique(SysRole role) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",role.getName());
        SysRole sysRole = roleMapper.selectOne(queryWrapper);
        return sysRole==null;
    }

    @Override
    public List<SysRole> listRole(SysRole role) {
        QueryWrapper<SysRole> queryWrapper = ObjectUtil.getListQuery(role);
        return roleMapper.selectList(queryWrapper);
    }
}