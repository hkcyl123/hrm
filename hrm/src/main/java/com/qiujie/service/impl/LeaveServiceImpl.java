package com.qiujie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.enums.LeaveEnum;
import com.qiujie.entity.Leave;
import com.qiujie.mapper.LeaveMapper;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.service.LeaveService;
import com.qiujie.util.EnumUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *

 */
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

    @Resource
    private LeaveMapper leaveMapper;

    public ResponseDTO add(Leave leave) {
        if (save(leave)) {
            return Response.success();
        }
        return Response.error();
    }

    public ResponseDTO deleteById(Integer id) {
        if (removeById(id)) {
            return Response.success();
        }
        return Response.error();
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids) {
        if (removeBatchByIds(ids)) {
            return Response.success();
        }
        return Response.error();
    }

    public ResponseDTO edit(Leave leave) {
        if (updateById(leave)) {
            return Response.success();
        }
        return Response.error();
    }

    public ResponseDTO findById(Integer id) {
        Leave leave = getById(id);
        if (leave != null) {
            return Response.success(leave);
        }
        return Response.error();
    }

    public ResponseDTO find(Integer deptId, Integer typeNum) {
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_id", deptId).eq("type_num", typeNum);
        Leave leave = getOne(queryWrapper);
        if (leave != null) {
            return Response.success(leave);
        }
        return Response.error();
    }

    public ResponseDTO setLeave(Leave leave) {
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_id", leave.getDeptId()).eq("type_num", leave.getTypeNum().getCode());
        if (saveOrUpdate(leave, queryWrapper)) {
            return Response.success();
        }
        return Response.error();
    }

    public ResponseDTO findByDeptId(Integer id) {
        List<Leave> list = this.leaveMapper.findByDeptId(id);
        return Response.success(list);
    }

    /**
     * 获取所有请假类型
     * @return
     */
    public ResponseDTO findAll() {
        return Response.success(EnumUtil.getEnumList(LeaveEnum.class));
    }
}
