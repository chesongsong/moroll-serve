package com.moroll.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 16:47
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @NotNull(message = "不能为空")
    @TableField("name")
    private String name;

    @TableField("sort_num")
    private Integer sortNum;
}
