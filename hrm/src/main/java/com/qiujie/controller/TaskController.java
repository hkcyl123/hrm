package com.qiujie.controller;

import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.StaffOnboardingProcess;
import com.qiujie.entity.Task;
import com.qiujie.service.StaffOnboardingProcessService;
import com.qiujie.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @ApiOperation("新增")
    @PostMapping
    public ResponseDTO add(@RequestBody Task task) {
        return new ResponseDTO(this.taskService.save(task));
    }

    @ApiOperation("id查询")
    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable Integer id) {
        return new ResponseDTO(this.taskService.getById(id));
    }

    @ApiOperation("list")
    @GetMapping("/page")
    public ResponseDTO getListByDeptId(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String taskName) {
        return new ResponseDTO(this.taskService.getList(current, size, taskName));
    }

    @ApiOperation("update")
    @PutMapping("/{id}")
    public ResponseDTO updateById(@PathVariable Integer id, @RequestBody Task task) {
        task.setId(id);
        return new ResponseDTO(this.taskService.updateById(task));
    }

    @ApiOperation("delete")
    @DeleteMapping("/{id}")
    public ResponseDTO deleteById(@PathVariable Integer id) {
        return new ResponseDTO(this.taskService.removeById(id));
    }
}
