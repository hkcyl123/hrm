package com.qiujie.controller;

import com.qiujie.dto.OnboardingProcessAddParams;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Menu;
import com.qiujie.entity.OnboardingProcess;
import com.qiujie.entity.Staff;
import com.qiujie.service.OnboardingProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onboardingProcess")
public class OnboardingProcessController {

    private OnboardingProcessService onboardingProcessService;

    public OnboardingProcessController(OnboardingProcessService onboardingProcessService) {
        this.onboardingProcessService = onboardingProcessService;
    }


    @ApiOperation("新增")
    @PostMapping
    public ResponseDTO add(@RequestBody OnboardingProcess onboardingProcess) {
        return new ResponseDTO(this.onboardingProcessService.save(onboardingProcess));
    }

    @ApiOperation("id查询")
    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable Integer id) {
        return new ResponseDTO(this.onboardingProcessService.getById(id));
    }

    @ApiOperation("list")
    @GetMapping("/page/{deptId}")
    public ResponseDTO getListByDeptId(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, @PathVariable Integer deptId) {
        return new ResponseDTO(this.onboardingProcessService.getListByDeptId(deptId, current, size));
    }

    @ApiOperation("update")
    @PutMapping("/{id}")
    public ResponseDTO updateById(@PathVariable Integer id, @RequestBody OnboardingProcess onboardingProcess) {
        onboardingProcess.setId(id);
        return new ResponseDTO(this.onboardingProcessService.updateById(onboardingProcess));
    }

    @ApiOperation("delete")
    @DeleteMapping("/{id}")
    public ResponseDTO deleteById(@PathVariable Integer id) {
        return new ResponseDTO(this.onboardingProcessService.removeById(id));
    }




}
