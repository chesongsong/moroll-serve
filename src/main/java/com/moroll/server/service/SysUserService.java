package com.moroll.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moroll.server.common.Result;
import com.moroll.server.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    Result login(SysUser user);

    Result logout();

    int register(SysUser user);

    Result getInfo();
}
