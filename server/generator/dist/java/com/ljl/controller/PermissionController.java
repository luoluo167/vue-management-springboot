package com.ljl.controller;

import com.alibaba.excel.EasyExcel;
import com.ljl.query.PermissionQuery;
import com.ljl.response.ResponseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ljl.entity.Permission;
import com.ljl.query.PermissionQuery;
import com.ljl.service.PermissionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>权限 前端控制器</p>
 *
 * @author ljl
 * @since 2020-04-22
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/permission/page")
    public IPage<Permission> page(@RequestBody PermissionQuery query){
        return permissionService.page(query);
    }

    @RequestMapping("/permission/list")
    public List<Permission> list(@RequestBody PermissionQuery query){
        return permissionService.list();
    }

    @RequestMapping("/permission/findById")
    public ResponseData findById(@RequestParam Integer id) {
        Permission permission = permissionService.getById(id);
        return ResponseData.success(permission);
    }

    @RequestMapping("/permission/save")
    public ResponseData save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return ResponseData.success(permission);
    }

    @RequestMapping("/permission/update")
    public ResponseData update(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return ResponseData.success(permission);
    }

    @RequestMapping("/permission/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
        permissionService.removeByIds(id);
        return ResponseData.success(id);
    }

    @ResponseBody
    @RequestMapping("/permission/export")
    public void export(PermissionQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("权限.xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), Permission.class).sheet("权限").doWrite(list(query));
    }
}
