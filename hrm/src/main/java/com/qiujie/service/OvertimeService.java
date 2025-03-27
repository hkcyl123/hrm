package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Overtime;
import com.qiujie.enums.OvertimeEnum;
import com.qiujie.util.EnumUtil;

import java.util.List;
import java.util.Map;

public interface OvertimeService extends IService<Overtime> {

    public ResponseDTO add(Overtime overtime);

    public ResponseDTO deleteById(Integer id);

    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(Overtime overtime);


    public ResponseDTO findById(Integer id);

    public ResponseDTO find(Integer deptId, Integer typeNum);


    public ResponseDTO setOvertime(Overtime overtime);


    /**
     * 获取所有加班类型
     * @return
     */
    public ResponseDTO findAll();
}
