package com.qiujie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("task")
@ApiModel(value = "任务", description = "")
public class Task {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("dept_id")
    private Integer deptId;

    @TableField("process_name")
    private String taskName;

    @TableField("process_details")
    private String taskDetails;

    @TableField("create_staff_id")
    private Integer createStaffId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
