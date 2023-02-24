package com.moroll.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-20 22:37
 */
@Data
public class BaseEntity {
    @TableField("create_time")
    private Date createTime;

    @TableField("create_by")
    private String createBy;

    @TableField("update_time")
    private Date updateTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("remark")
    private String remark;
}
