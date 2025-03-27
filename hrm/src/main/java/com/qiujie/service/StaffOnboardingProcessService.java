package com.qiujie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.entity.StaffOnboardingProcess;

public interface StaffOnboardingProcessService extends IService<StaffOnboardingProcess> {
    StaffOnboardingProcess getListByDeptId(Integer deptId);
}
