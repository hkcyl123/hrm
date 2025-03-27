package com.qiujie.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.dto.Response;
import com.qiujie.entity.Dept;
import com.qiujie.entity.OnboardingProcess;
import com.qiujie.entity.Staff;
import com.qiujie.mapper.OnboardingProcessMapper;
import com.qiujie.service.DeptService;
import com.qiujie.service.OnboardingProcessService;
import com.qiujie.vo.OnboardingProcessVO;
import com.qiujie.vo.StaffDeptVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OnboardingProcessServiceImpl extends ServiceImpl<OnboardingProcessMapper, OnboardingProcess> implements OnboardingProcessService {

    private final DeptService deptService;

    public OnboardingProcessServiceImpl(DeptService deptService) {
        this.deptService = deptService;
    }

    @Override
    public Map getListByDeptId(Integer deptId, Integer current, Integer size) {

        IPage<OnboardingProcess> pageConfig = new Page<>(current, size);

        IPage<OnboardingProcess> page = page(pageConfig, new LambdaQueryWrapper<OnboardingProcess>().eq(OnboardingProcess::getDeptId, deptId));
        List<OnboardingProcess> records = page.getRecords();
        List<OnboardingProcessVO> onboardingProcessVOS = new ArrayList<>();
        for (OnboardingProcess record : records) {
            Dept dept = this.deptService.getById(record.getDeptId());
            onboardingProcessVOS.add(new OnboardingProcessVO(record, dept));
        }
        Map map = new HashMap();
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", onboardingProcessVOS);
        return map;
    }
}
