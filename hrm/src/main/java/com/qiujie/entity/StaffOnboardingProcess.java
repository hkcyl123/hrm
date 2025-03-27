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
@TableName("staff_onboarding_process")
@ApiModel(value = "入职流程对象", description = "")
public class StaffOnboardingProcess {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("staff_id")
    private Integer staffId;

    @TableField("dept_id")
    private Integer deptId;

    @TableField("process_id")
    private String processId;

    @TableField("status")
    private Boolean status;

    @TableField("remark")
    private String remark;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
