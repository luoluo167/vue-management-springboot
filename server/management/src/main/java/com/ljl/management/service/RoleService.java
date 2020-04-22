package com.ljl.management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.management.entity.Role;
import com.ljl.management.mapper.RoleMapper;
import com.ljl.management.query.RoleQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>角色 服务实现类</p>
 *
 * @author tianlihu
 * @since 2020-04-14
 */
@Service
@Transactional
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    public IPage<Role> page(RoleQuery query) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(Role role) {
        Role dbRole = getById(role.getRoleId());
        dbRole.setName(role.getName());
        dbRole.setSort(role.getSort());
        dbRole.setRemark(role.getRemark());
        return super.updateById(role);
    }
}

