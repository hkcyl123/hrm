package com.qiujie.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Attendance;
import com.qiujie.entity.Dept;
import com.qiujie.enums.AttendanceStatusEnum;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;
import com.qiujie.util.DatetimeUtil;
import com.qiujie.util.EnumUtil;
import com.qiujie.util.HutoolExcelUtil;
import com.qiujie.vo.AttendanceMonthVO;
import com.qiujie.vo.StaffAttendanceVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AttendanceService extends IService<Attendance> {

    ResponseDTO add(Attendance attendance);

    ResponseDTO deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    ResponseDTO deleteBatch(List<Integer> ids);

    ResponseDTO edit(Attendance attendance);

    ResponseDTO findById(Integer id);

    ResponseDTO list(Integer current, Integer size, String name,Integer deptId, String month);

    /**
     * 导出员工月考勤数据
     *
     * @param response
     * @param month
     * @return
     */
    ResponseDTO export(HttpServletResponse response, String month) throws IOException;

    /**
     * 数据导入
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    ResponseDTO imp(MultipartFile file) throws IOException ;

    /**
     * 查找员工最近一次休假的日期
     *
     * @param id
     * @return
     */
    ResponseDTO findByStaffId(Integer id);

    ResponseDTO setAttendance(Attendance attendance);

    ResponseDTO findAll();

    ResponseDTO findByStaffIdAndDate(Integer id, String date);
}
