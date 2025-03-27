package com.qiujie.controller;

import com.qiujie.entity.Staff;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.service.StaffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录注册接口
 *
 *
 */
@RestController
public class LoginController {

    @Resource
    private StaffService staffService;

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody Staff staff) {
        return this.staffService.login(staff);
    }
}
