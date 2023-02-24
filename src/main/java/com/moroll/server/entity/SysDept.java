package com.moroll.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-24 14:42
 */
@Data
@TableName("sys_dept")
public class SysDept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("parent_id")
    private String parentId;

    @NotEmpty(message = "不能为空")
    @TableField("name")
    private String name;

    @TableField("sort_num")
    private Integer sortNum;

}