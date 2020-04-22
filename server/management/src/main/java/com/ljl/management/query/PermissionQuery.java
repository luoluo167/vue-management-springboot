package com.ljl.management.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.management.entity.Permission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("权限查询条件")
public class PermissionQuery extends Page<Permission> {

    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;
    @ApiModelProperty(value = "是否菜单", notes = "是否菜单")
    private String menu;
}
