package com.moroll.server.controller;

import com.moroll.server.common.Result;
import com.moroll.server.entity.SysRole;
import com.moroll.server.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 17:35
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @PostMapping
    public Result add(@Valid @RequestBody SysRole role){
        if(!sysRoleService.isUnique(role)){
            return Result.error("新增角色："+role.getName()+"失败，角色名称已存在");
        };
        // 不存在则新建
        return Result.success(sysRoleService.save(role));
    }

    @GetMapping
    public Result list(SysRole role) {
        return Result.success(sysRoleService.listRole(role));
    }

    @PutMapping
    public Result put(@RequestBody SysRole role){
        return Result.success(sysRoleService.updateById(role));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value="id") String id){
        return Result.success(sysRoleService.removeById(id));
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable(value="id") String id) {
        return Result.success((sysRoleService.getById(id)));
    }
}