package com.ljl.management.controller;

import com.alibaba.excel.EasyExcel;
import com.ljl.management.query.DepartmentQuery;
import com.ljl.management.response.ResponseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ljl.management.entity.Department;
import com.ljl.management.service.DepartmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>部门 前端控制器</p>
 *
 * @author tianlihu
 * @since 2020-04-14
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department/page")
    public IPage<Department> page(@RequestBody DepartmentQuery query){
        return departmentService.page(query);
    }

    @RequestMapping("/department/list")
    public List<Department> list(@RequestBody DepartmentQuery query){
        return departmentService.list();
    }

    @RequestMapping("/department/findById")
    public ResponseData findById(@RequestParam Integer id) {
        Department department = departmentService.getById(id);
        return ResponseData.success(department);
    }

    @RequestMapping("/department/save")
    public ResponseData save(@RequestBody Department department) {
        departmentService.save(department);
        return ResponseData.success(department);
    }

    @RequestMapping("/department/update")
    public ResponseData update(@RequestBody Department department) {
        departmentService.updateById(department);
        return ResponseData.success(department);
    }

    @RequestMapping("/department/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
        departmentService.removeByIds(id);
        return ResponseData.success(id);
    }

    @ResponseBody
    @RequestMapping("/department/export")
    public void export(DepartmentQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("部门.xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), Department.class).sheet("部门").doWrite(list(query));
    }
}
