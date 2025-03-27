package com.qiujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.entity.TaskStaff;
import com.qiujie.mapper.TaskStaffMapper;
import com.qiujie.service.TaskStaffService;
import org.springframework.stereotype.Service;

@Service
public class TaskStaffServiceImpl extends ServiceImpl<TaskStaffMapper, TaskStaff> implements TaskStaffService {
}
