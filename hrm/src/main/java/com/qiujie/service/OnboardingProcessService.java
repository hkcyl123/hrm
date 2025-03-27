package com.qiujie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.entity.OnboardingProcess;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public interface OnboardingProcessService extends IService<OnboardingProcess> {
    Map getListByDeptId(Integer deptId, Integer current, Integer size);
}
