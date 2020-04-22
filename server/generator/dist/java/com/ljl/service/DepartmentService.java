package com.ljl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.entity.Department;
import com.ljl.mapper.DepartmentMapper;
import com.ljl.query.DepartmentQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>部门 服务实现类</p>
 *
 * @author ljl
 * @since 2020-04-22
 */
@Service
@Transactional
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {

    public IPage<Department> page(DepartmentQuery query) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        if (query.getDepartmentId() != null) {
            wrapper.eq("department_id", query.getDepartmentId());
        }
        if (query.getParentId() != null) {
            wrapper.eq("parent_id", query.getParentId());
        }
        if (StringUtils.isNotBlank(query.getShortName())) {
            wrapper.like("short_name", query.getShortName());
        }
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (query.getSort() != null) {
            wrapper.eq("sort", query.getSort());
        }
        if (StringUtils.isNotBlank(query.getRemark())) {
            wrapper.like("remark", query.getRemark());
        }
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(Department department) {
        Department dbDepartment = getById(department.getDepartmentId());
        dbDepartment.setParentId(department.getParentId());
        dbDepartment.setShortName(department.getShortName());
        dbDepartment.setName(department.getName());
        dbDepartment.setSort(department.getSort());
        dbDepartment.setRemark(department.getRemark());
        return super.updateById(department);
    }
}

