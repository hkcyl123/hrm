package com.qiujie.controller;


import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Task;
import com.qiujie.entity.TaskStaff;
import com.qiujie.service.TaskService;
import com.qiujie.service.TaskStaffService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

public class TaskStaffController {

    private final TaskStaffService taskStaffService;

    public TaskStaffController(TaskStaffService taskStaffService) {
        this.taskStaffService = taskStaffService;
    }


    @ApiOperation("新增")
    @PostMapping
    public ResponseDTO add(@RequestBody TaskStaff taskStaff) {
        return new ResponseDTO(this.taskStaffService.save(taskStaff));
    }

    @ApiOperation("id查询")
    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable Integer id) {
        return new ResponseDTO(this.taskStaffService.getById(id));
    }

    @ApiOperation("list")
    @GetMapping("")
    public ResponseDTO getListByDeptId() {
        return new ResponseDTO(this.taskStaffService.list());
    }

    @ApiOperation("update")
    @PutMapping("/{id}")
    public ResponseDTO updateById(@PathVariable Integer id, @RequestBody TaskStaff taskStaff) {
        taskStaff.setId(id);
        return new ResponseDTO(this.taskStaffService.updateById(taskStaff));
    }

    @ApiOperation("delete")
    @DeleteMapping("/{id}")
    public ResponseDTO deleteById(@PathVariable Integer id) {
        return new ResponseDTO(this.taskStaffService.removeById(id));
    }

}
