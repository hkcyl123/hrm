package com.qiujie.service;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Menu;
import com.qiujie.entity.RoleMenu;
import com.qiujie.entity.StaffRole;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;
import com.qiujie.util.HutoolExcelUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public interface MenuService extends IService<Menu> {

    public ResponseDTO add(Menu menu);

    public ResponseDTO deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(Menu menu);


    public ResponseDTO findById(Integer id);

    /**
     * 查找所有菜单
     *
     * @return
     */
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
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO imp(MultipartFile file) throws IOException;

    /**
     * 为父级菜单设置子菜单，使用流来处理数据，并返回父级菜单
     *
     * @param list
     * @return
     */
    public List<Menu> setSubMenu(List<Menu> list);

    public ResponseDTO getStaffMenu(HttpServletRequest request);


    /**
     * 通过员工id查询菜单,使用流处理数据，减少对数据库的查询次数
     *
     * @param id
     * @return
     */
    public ResponseDTO getStaffMenuPlus(Integer id) ;
}
