package com.moroll.server.controller;

import com.moroll.server.common.Result;
import com.moroll.server.entity.SysDept;
import com.moroll.server.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 14:48
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Autowired
    SysDeptService deptService;

    @PostMapping
    public Result add(@Valid @RequestBody SysDept dept){
        // 部门是否已经存在
        if(!deptService.isUnique(dept)){
            return Result.error("新增部门："+dept.getName()+"失败，部门名称已存在");
        };
        // 不存在则新建
        return Result.success(deptService.save(dept));
    }

    @GetMapping
    public Result list(SysDept dept) {
        return Result.success(deptService.listDept(dept));
    }

    @PutMapping
    public Result put(@RequestBody SysDept dept){
        return Result.success(deptService.updateById(dept));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value="id") String id){
        return Result.success(deptService.removeById(id));
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable(value="id") String id) {
        return Result.success((deptService.getById(id)));
    }
}