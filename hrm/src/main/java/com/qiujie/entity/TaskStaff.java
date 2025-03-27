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
@TableName("task_staff")
@ApiModel(value = "任务", description = "")
public class TaskStaff {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("dept_id")
    private Integer deptId;

    @TableField("task_id")
    private Integer taskId;

    @TableField("staff_id")
    private Integer staffId;

    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

}
