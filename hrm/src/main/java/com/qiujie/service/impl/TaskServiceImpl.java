package com.qiujie.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.entity.Dept;
import com.qiujie.entity.OnboardingProcess;
import com.qiujie.entity.Staff;
import com.qiujie.entity.Task;
import com.qiujie.mapper.TaskMapper;
import com.qiujie.service.StaffService;
import com.qiujie.service.TaskService;
import com.qiujie.vo.OnboardingProcessVO;
import com.qiujie.vo.TaskVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    final private StaffService staffService;

    public TaskServiceImpl(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public Map getList(Integer current, Integer size, String taskName) {

        IPage<Task> pageConfig = new Page<>(current, size);

        IPage<Task> page = page(pageConfig, new LambdaQueryWrapper<Task>().like(!StrUtil.isEmpty(taskName), Task::getTaskName, taskName));
        List<Task> records = page.getRecords();
        List<TaskVO> taskVOS = new ArrayList<>();
        for (Task record : records) {
            Staff staff = this.staffService.getById(record.getCreateStaffId());
            taskVOS.add(new TaskVO(record, staff));
        }
        Map map = new HashMap();
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", taskVOS);
        return map;
    }
}
