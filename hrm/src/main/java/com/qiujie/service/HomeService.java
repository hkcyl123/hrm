package com.qiujie.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Attendance;
import com.qiujie.entity.City;
import com.qiujie.entity.Dept;
import com.qiujie.entity.Staff;
import com.qiujie.enums.AttendanceStatusEnum;
import com.qiujie.util.DatetimeUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface HomeService {

    public ResponseDTO getStaffData();

    // 统计数据
    public ResponseDTO getCountData();

    public ResponseDTO getCityData();


    /**
     * 统计员工当月的考勤信息
     * @param id 员工id
     * @param month
     * @return
     */
    public ResponseDTO getAttendanceData(Integer id, String month);


    // 统计各部门的人数情况
    public ResponseDTO getDepartmentData();
}
