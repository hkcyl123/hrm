package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Leave;
import com.qiujie.enums.LeaveEnum;
import com.qiujie.util.EnumUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeaveService extends IService<Leave> {

    public ResponseDTO add(Leave leave);

    public ResponseDTO deleteById(Integer id);
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids);

    public ResponseDTO edit(Leave leave);

    public ResponseDTO findById(Integer id) ;

    public ResponseDTO find(Integer deptId, Integer typeNum);

    public ResponseDTO setLeave(Leave leave);

    public ResponseDTO findByDeptId(Integer id) ;

    /**
     * 获取所有请假类型
     * @return
     */
    public ResponseDTO findAll();
}
