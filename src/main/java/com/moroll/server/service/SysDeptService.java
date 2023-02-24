package com.moroll.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moroll.server.entity.SysDept;

import java.util.List;

public interface SysDeptService extends IService<SysDept> {
    /**
     * 查询部门是否唯一
     * @param dept
     * @return
     */
    Boolean isUnique(SysDept dept);

    List<SysDept> listDept(SysDept dept);
}
