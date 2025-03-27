package com.qiujie.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Attendance;
import com.qiujie.entity.StaffLeave;
import com.qiujie.enums.AttendanceStatusEnum;
import com.qiujie.enums.AuditStatusEnum;
import com.qiujie.util.EnumUtil;
import com.qiujie.util.HutoolExcelUtil;
import com.qiujie.vo.StaffLeaveVO;
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

public interface StaffLeaveService extends IService<StaffLeave> {

    public ResponseDTO add(StaffLeave staffLeave);

    public ResponseDTO deleteById(Integer id);

    public ResponseDTO deleteBatch(List<Integer> ids);

    /**
     * 设置请假，当请假通过之后，就将休假的考勤状态设为休假
     *
     * @param staffLeave
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO edit(StaffLeave staffLeave);


    public ResponseDTO findById(Integer id);


    public ResponseDTO list(Integer current, Integer size, String name,Integer deptId);

    /**
     * 数据导出
     *
     * @param response
     * @return
     */
    public ResponseDTO export(HttpServletResponse response) throws IOException;

    /**
     * 数据导入
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO imp(MultipartFile file) throws IOException;


    public ResponseDTO findByStaffId(Integer current, Integer size, Integer id);


    /**
     * 查找未被审批的申请
     *
     * @param id
     * @return
     */
    public ResponseDTO findUnauditedByStaffId(Integer id);

    public ResponseDTO findAll();
}
