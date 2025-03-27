package com.qiujie.vo;

import com.qiujie.entity.Staff;
import com.qiujie.entity.Task;
import lombok.Data;

import java.util.Date;

@Data
public class TaskVO {

    private Integer id;

    private String taskName;

    private String taskDetails;

    private Integer createStaffId;

    private String createStaffName;

    private Date createTime;

    private Date updateTime;


    public TaskVO(Task task, Staff staff) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.taskDetails = task.getTaskDetails();
        this.createStaffId = task.getCreateStaffId();
        this.createStaffName = staff.getName();
        this.createTime = task.getCreateTime();
        this.updateTime = task.getUpdateTime();
    }
}
