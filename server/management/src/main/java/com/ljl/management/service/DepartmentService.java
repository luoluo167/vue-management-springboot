package com.ljl.management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.management.entity.Department;
import com.ljl.management.mapper.DepartmentMapper;
import com.ljl.management.query.DepartmentQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>部门 服务实现类</p>
 *
 * @author tianlihu
 * @since 2020-04-14
 */
@Service
@Transactional
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {

    public IPage<Department> page(DepartmentQuery query) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getShortName())) {
            wrapper.like("short_name", query.getShortName());
        }
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
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

