package com.moroll.server.controller;

import com.moroll.server.common.Result;
import com.moroll.server.entity.SysUser;
import com.moroll.server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-21 19:56
 */

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/{id}")
    public SysUser getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @GetMapping("/info")
    public Result getById() {
        return userService.getInfo();
    }

    @GetMapping
    public List<SysUser> list() {
        return userService.list();
    }

    @PutMapping
    public boolean update(@Valid @RequestBody SysUser user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    public boolean remove(@PathVariable("id") String id) {
        return userService.removeById(id);
    }

    @PostMapping("/login")
    public Result login(@RequestBody SysUser user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public Result logout(){
        return userService.logout();
    }

    @PostMapping("/register")
    public Result register(@Valid @RequestBody SysUser user){
        return new Result(HttpStatus.OK.value(),"注册成功",userService.register(user));
    }
}