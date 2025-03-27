package com.qiujie.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.entity.OnboardingProcess;
import com.qiujie.entity.StaffOnboardingProcess;
import com.qiujie.mapper.OnboardingProcessMapper;
import com.qiujie.mapper.StaffOnboardingProcessMapper;
import com.qiujie.service.StaffOnboardingProcessService;
import org.springframework.stereotype.Service;

@Service
public class StaffOnboardingProcessServiceImpl extends ServiceImpl<StaffOnboardingProcessMapper, StaffOnboardingProcess> implements StaffOnboardingProcessService {
    @Override
    public StaffOnboardingProcess getListByDeptId(Integer deptId) {
        return null;
    }
}
