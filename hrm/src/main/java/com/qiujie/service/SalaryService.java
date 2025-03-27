package com.qiujie.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Salary;
import com.qiujie.entity.SalaryDeduct;
import com.qiujie.enums.AttendanceStatusEnum;
import com.qiujie.enums.DeductEnum;
import com.qiujie.util.HutoolExcelUtil;
import com.qiujie.vo.StaffSalaryVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SalaryService extends IService<Salary> {

    public ResponseDTO add(Salary salary);

    public ResponseDTO deleteById(Integer id);

    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(Salary salary);


    public ResponseDTO findById(Integer id);


    public ResponseDTO list(Integer current, Integer size, String name, Integer deptId, String month);

    /**
     * 数据导出
     *
     * @param response
     * @return
     */
    public ResponseDTO export(HttpServletResponse response, String month) throws IOException;


    /**
     * 数据导入
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO imp(MultipartFile file) throws IOException;


    public ResponseDTO setSalary(Salary salary);


    /**
     * 每次迟到扣款
     *
     * @param staffSalaryVO
     * @return
     */
    public Integer getPerLateDeduct(StaffSalaryVO staffSalaryVO);

    /**
     * 每次早退扣款
     *
     * @param staffSalaryVO
     * @return
     */
    public Integer getPerLeaveEarlyDeduct(StaffSalaryVO staffSalaryVO);

    /**
     * 每次旷工扣款
     *
     * @param staffSalaryVO
     * @return
     */
    public Integer getPerAbsenteeismDeduct(StaffSalaryVO staffSalaryVO);

    /**
     * 每次休假扣款
     *
     * @param staffSalaryVO
     * @return
     */
    public Integer getPerLeaveDeduct(StaffSalaryVO staffSalaryVO);
}
