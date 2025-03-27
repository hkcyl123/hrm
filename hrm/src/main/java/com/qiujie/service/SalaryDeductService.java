package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.SalaryDeduct;
import com.qiujie.enums.DeductEnum;
import com.qiujie.util.EnumUtil;

import java.util.List;

public interface SalaryDeductService extends IService<SalaryDeduct> {

    public ResponseDTO add(SalaryDeduct salaryDeduct);

    public ResponseDTO deleteById(Integer id);

    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(SalaryDeduct salaryDeduct) ;


    public ResponseDTO findById(Integer id);

    public ResponseDTO find(Integer deptId, Integer typeNum);


    public ResponseDTO setSalaryDeduct(SalaryDeduct salaryDeduct);

    /**
     * 获取所有罚款类型
     * @return
     */
    public ResponseDTO findAll() ;
}
