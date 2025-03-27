package com.qiujie.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Role;
import com.qiujie.util.HutoolExcelUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RoleService extends IService<Role> {
    public ResponseDTO add(Role role);

    public ResponseDTO deleteById(Integer id);

    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(Role role);


    public ResponseDTO findById(Integer id);

    public ResponseDTO findAll();


    public ResponseDTO list(Integer current, Integer size, String name);

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
    @Transactional
    public ResponseDTO imp(MultipartFile file) throws IOException ;

}
