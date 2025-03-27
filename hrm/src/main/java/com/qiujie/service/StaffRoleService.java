package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.StaffRole;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;

import java.util.List;

public interface StaffRoleService extends IService<StaffRole> {

    public ResponseDTO setRole(Integer staffId, List<Integer> roleIds);

    public ResponseDTO getRole(Integer staffId);
}
