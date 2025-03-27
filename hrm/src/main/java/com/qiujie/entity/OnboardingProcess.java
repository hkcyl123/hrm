package com.qiujie.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("onboarding_process")
@ApiModel(value = "入职流程对象", description = "")
public class OnboardingProcess {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("dept_id")
    private Integer deptId;

    @TableField("process_name")
    private String processName;

    @TableField("process_details")
    private String processDetails;

    @TableField("sort")
    private Integer sort;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

}
