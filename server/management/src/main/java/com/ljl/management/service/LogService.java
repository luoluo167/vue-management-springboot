package com.ljl.management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.management.entity.Log;
import com.ljl.management.mapper.LogMapper;
import com.ljl.management.query.LogQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>日志 服务实现类</p>
 *
 * @author tianlihu
 * @since 2020-04-14
 */
@Service
@Transactional
public class LogService extends ServiceImpl<LogMapper, Log> {

    public IPage<Log> page(LogQuery query) {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        if (query.getUserId() != null) {
            wrapper.eq("user_id", query.getUserId());
        }
        if (StringUtils.isNotBlank(query.getType())) {
            wrapper.like("type", query.getType());
        }
        if (query.getCreateTime() != null) {
            wrapper.eq("create_time", query.getCreateTime());
        }
        if (StringUtils.isNotBlank(query.getContent())) {
            wrapper.like("content", query.getContent());
        }
        if (StringUtils.isNotBlank(query.getIp())) {
            wrapper.like("ip", query.getIp());
        }
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(Log log) {
        Log dbLog = getById(log.getLogId());
        dbLog.setUserId(log.getUserId());
        dbLog.setType(log.getType());
        dbLog.setCreateTime(log.getCreateTime());
        dbLog.setContent(log.getContent());
        dbLog.setIp(log.getIp());
        return super.updateById(log);
    }
}

