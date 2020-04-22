package com.ljl.management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.management.entity.Position;
import com.ljl.management.mapper.PositionMapper;
import com.ljl.management.query.PositionQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>职位 服务实现类</p>
 *
 * @author tianlihu
 * @since 2020-04-14
 */
@Service
@Transactional
public class PositionService extends ServiceImpl<PositionMapper, Position> {

    public IPage<Position> page(PositionQuery query) {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (StringUtils.isNotBlank(query.getCode())) {
            wrapper.like("code", query.getCode());
        }
        if (query.getStatus() != null) {
            wrapper.eq("status", query.getStatus());
        }
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(Position position) {
        Position dbPosition = getById(position.getPositionId());
        dbPosition.setName(position.getName());
        dbPosition.setCode(position.getCode());
        dbPosition.setCreateTime(position.getCreateTime());
        dbPosition.setUpdateTime(position.getUpdateTime());
        dbPosition.setStatus(position.getStatus());
        dbPosition.setDel(position.getDel());
        return super.updateById(position);
    }
}

