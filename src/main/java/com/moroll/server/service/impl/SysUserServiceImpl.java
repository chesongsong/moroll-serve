package com.moroll.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moroll.server.common.Result;
import com.moroll.server.entity.SysUser;
import com.moroll.server.mapper.SysUserMapper;
import com.moroll.server.service.SysUserService;
import com.moroll.server.utils.JwtUtil;
import com.moroll.server.utils.RedisCache;
import com.moroll.server.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-21 20:02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService, UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public Result login(SysUser user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }

        SysUser loginUser = (SysUser) authenticate.getPrincipal();
        String uid = loginUser.getId();

        Map<String,Object> claims = new HashMap<>();
        claims.put("uid",uid);
        // 生产token
        String jwt = JwtUtil.generateToken(claims);
        // 组装返回结果
        Map<String,String> result = new HashMap<>();
        result.put("token",jwt);

        redisCache.setCacheObject("login:"+uid,loginUser);
        return new Result(HttpStatus.OK.value(), "登录成功",result);
    }

    @Override
    public Result logout() {
        //1. 获取要退出的用户id，获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        SysUser loginUser = (SysUser) authentication.getPrincipal();
        String userid = loginUser.getId();
        //清空redis中的数据
        redisCache.deleteObject("login:"+userid);
        return new Result(HttpStatus.OK.value(), "退出成功");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        SysUser user = userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名不存在");
        }
        // 将权限信息存入user中
        return user;
    }

    public int register(SysUser user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        return userMapper.insert(user);
    }

    /**
     * 从token中获取用户id
     * @return
     */
    @Override
    public Result getInfo() {
        SysUser user = UserUtil.getUserByToken();
        return Result.success(userMapper.selectById(user.getId()));
    }
}