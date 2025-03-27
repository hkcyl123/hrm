package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Dept;
import com.qiujie.util.HutoolExcelUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DeptService extends IService<Dept> {

    public ResponseDTO add(Dept dept);

    public ResponseDTO deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids);

    public ResponseDTO edit(Dept dept);

    /**
     * 查找所有部门
     *
     * @return
     */
    public ResponseDTO findAll();

    public ResponseDTO findById(Integer id);

    public ResponseDTO list(Integer current, Integer size, String name);
    /**
     * 数据导出
     *
     * @param response
     * @return
     */
    public ResponseDTO export(HttpServletResponse response) throws Exception;

    /**
     * 数据导入
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO imp(MultipartFile file) throws IOException;
    /**
     * 为父级部门设置子部门，使用流来处理数据，并返回父级部门
     *
     * @param list
     * @return
     */
    public List<Dept> setSubDept(List<Dept> list);

    /**
     * 得到所有的子部门
     *
     * @return
     */
    public ResponseDTO findAllSubDept();

    // 计算员工每天的上班时间
    public BigDecimal calculateTotalWorkTime(Dept dept);
}
