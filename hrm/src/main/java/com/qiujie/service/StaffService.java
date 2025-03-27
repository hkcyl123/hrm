package com.qiujie.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Dept;
import com.qiujie.entity.Staff;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;
import com.qiujie.util.HutoolExcelUtil;
import com.qiujie.util.JWTUtil;
import com.qiujie.util.MD5Util;
import com.qiujie.vo.StaffDeptVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StaffService extends IService<Staff> {

    public ResponseDTO login(Staff staff);


    /**
     * 新增
     *
     * @param staff
     * @return ResponseDTO
     */
    public ResponseDTO add(Staff staff);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    public ResponseDTO deleteById(Integer id);

    /**
     * 编辑
     *
     * @param staff
     * @return
     */
    public ResponseDTO edit(Staff staff) ;

    /**
     * 查找
     *
     * @param id
     * @return
     */
    public ResponseDTO findById(Integer id);


    /**
     * 多条件分页查询
     *
     * @param current 当前页
     * @param size    页面显示的数据条数
     * @param staff
     * @return
     */
    public ResponseDTO list(Integer current, Integer size, Staff staff);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids);


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

    // 检查员工的密码
    public ResponseDTO checkPassword(String pwd, Integer id);

    public ResponseDTO updatePassword(Staff staff);

    /**
     * 获取员工信息
     *
     * @param id
     * @return
     */
    public ResponseDTO findInfoById(Integer id);
}
