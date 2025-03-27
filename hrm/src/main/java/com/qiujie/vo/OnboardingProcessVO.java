package com.qiujie.vo;

import com.qiujie.entity.Dept;
import com.qiujie.entity.OnboardingProcess;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OnboardingProcessVO {

    private Integer id;

    private Integer deptId;

    private String deptName;

    private String processName;

    private String processDetails;

    private Integer sort;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public OnboardingProcessVO(OnboardingProcess onboardingProcess, Dept dept) {
        this.id = onboardingProcess.getId();
        this.deptId = onboardingProcess.getDeptId();
        this.deptName = dept.getName();
        this.processName = onboardingProcess.getProcessName();
        this.processDetails = onboardingProcess.getProcessDetails();
        this.sort = onboardingProcess.getSort();
        this.createTime = onboardingProcess.getCreateTime();
        this.updateTime = onboardingProcess.getUpdateTime();

    }
}
