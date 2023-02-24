package com.moroll.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moroll.server.entity.SysDept;
import com.moroll.server.entity.SysRole;

import java.util.List;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 17:33
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 查询角色是否唯一
     * @param role
     * @return
     */
    Boolean isUnique(SysRole role);

    List<SysRole> listRole(SysRole role);
}