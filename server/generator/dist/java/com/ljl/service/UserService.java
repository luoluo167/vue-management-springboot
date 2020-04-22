package com.ljl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.entity.User;
import com.ljl.mapper.UserMapper;
import com.ljl.query.UserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>用户 服务实现类</p>
 *
 * @author ljl
 * @since 2020-04-22
 */
@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> {

    public IPage<User> page(UserQuery query) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (query.getUserId() != null) {
            wrapper.eq("user_id", query.getUserId());
        }
        if (query.getDepartmentId() != null) {
            wrapper.eq("department_id", query.getDepartmentId());
        }
        if (StringUtils.isNotBlank(query.getAccount())) {
            wrapper.like("account", query.getAccount());
        }
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (StringUtils.isNotBlank(query.getPassword())) {
            wrapper.like("password", query.getPassword());
        }
        if (StringUtils.isNotBlank(query.getPhone())) {
            wrapper.like("phone", query.getPhone());
        }
        if (query.getAdmin() != null) {
            wrapper.eq("admin", query.getAdmin());
        }
        if (query.getCreateTime() != null) {
            wrapper.eq("create_time", query.getCreateTime());
        }
        if (query.getUpdateTime() != null) {
            wrapper.eq("update_time", query.getUpdateTime());
        }
        if (query.getLastLoginTime() != null) {
            wrapper.eq("last_login_time", query.getLastLoginTime());
        }
        if (query.getLoginTimes() != null) {
            wrapper.eq("login_times", query.getLoginTimes());
        }
        if (query.getStatus() != null) {
            wrapper.eq("status", query.getStatus());
        }
        if (query.getDel() != null) {
            wrapper.eq("del", query.getDel());
        }
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(User user) {
        User dbUser = getById(user.getUserId());
        dbUser.setDepartmentId(user.getDepartmentId());
        dbUser.setAccount(user.getAccount());
        dbUser.setName(user.getName());
        dbUser.setPassword(user.getPassword());
        dbUser.setPhone(user.getPhone());
        dbUser.setAdmin(user.getAdmin());
        dbUser.setCreateTime(user.getCreateTime());
        dbUser.setUpdateTime(user.getUpdateTime());
        dbUser.setLastLoginTime(user.getLastLoginTime());
        dbUser.setLoginTimes(user.getLoginTimes());
        dbUser.setStatus(user.getStatus());
        dbUser.setDel(user.getDel());
        return super.updateById(user);
    }
}

