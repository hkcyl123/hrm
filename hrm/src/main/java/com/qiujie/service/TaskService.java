package com.qiujie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.entity.Task;

import java.util.Map;

public interface TaskService extends IService<Task> {
    Map getList(Integer current, Integer size, String taskName);
}
