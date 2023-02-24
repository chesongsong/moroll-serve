package com.moroll.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moroll.server.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
