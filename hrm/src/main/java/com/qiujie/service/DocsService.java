package com.qiujie.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Docs;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.exception.ServiceException;
import com.qiujie.util.HutoolExcelUtil;
import com.qiujie.vo.StaffDocsVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DocsService extends IService<Docs> {

    public ResponseDTO upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException;


    /**
     * 文件下载
     *
     * @param filename
     * @param response
     * @return
     * @throws IOException
     */
    public ResponseDTO download(String filename, HttpServletResponse response) throws IOException;


    public ResponseDTO add(Docs docs);

    public ResponseDTO deleteById(Integer id) ;

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids);


    public ResponseDTO edit(Docs docs);


    public ResponseDTO findById(Integer id);


    public ResponseDTO list(Integer current, Integer size, String oldName, String staffName);

    public ResponseDTO export(HttpServletResponse response) throws IOException;
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO imp(MultipartFile file) throws IOException;
}
