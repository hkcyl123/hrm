package com.qiujie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.RoleMenu;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;

import java.util.List;

public interface RoleMenuService extends IService<RoleMenu> {

    public ResponseDTO setMenu(Integer roleId, List<Integer> menuIds);

    /**
     * 获取角色的菜单
     *
     * @param roleId
     * @return
     */
    public ResponseDTO getMenu(Integer roleId);
}
