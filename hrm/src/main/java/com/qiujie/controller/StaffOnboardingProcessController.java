package com.qiujie.controller;

import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.OnboardingProcess;
import com.qiujie.entity.StaffOnboardingProcess;
import com.qiujie.service.OnboardingProcessService;
import com.qiujie.service.StaffOnboardingProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

public class StaffOnboardingProcessController {
    private final StaffOnboardingProcessService staffOnboardingProcessService;

    public StaffOnboardingProcessController(StaffOnboardingProcessService staffOnboardingProcessService) {
        this.staffOnboardingProcessService = staffOnboardingProcessService;
    }


    @ApiOperation("新增")
    @PostMapping
    public ResponseDTO add(@RequestBody StaffOnboardingProcess staffOnboardingProcess) {
        return new ResponseDTO(this.staffOnboardingProcessService.save(staffOnboardingProcess));
    }

    @ApiOperation("id查询")
    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable Integer id) {
        return new ResponseDTO(this.staffOnboardingProcessService.getById(id));
    }

    @ApiOperation("list")
    @GetMapping("/{deptId}")
    public ResponseDTO getListByDeptId(@PathVariable Integer deptId) {
        return new ResponseDTO(this.staffOnboardingProcessService.getListByDeptId(deptId));
    }

    @ApiOperation("update")
    @PutMapping("/{id}")
    public ResponseDTO updateById(@PathVariable Integer id, @RequestBody StaffOnboardingProcess staffOnboardingProcess) {
        staffOnboardingProcess.setId(id);
        return new ResponseDTO(this.staffOnboardingProcessService.updateById(staffOnboardingProcess));
    }

    @ApiOperation("delete")
    @DeleteMapping("/{id}")
    public ResponseDTO deleteById(@PathVariable Integer id) {
        return new ResponseDTO(this.staffOnboardingProcessService.removeById(id));
    }

}
