package com.ljl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("权限查询条件")
public class PermissionQuery extends PageQuery {

    @ApiModelProperty(value = "权限ID", notes = "权限ID")
    private String permissionId;
    @ApiModelProperty(value = "父权限ID", notes = "父权限ID")
    private String parentId;
    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;
    @ApiModelProperty(value = "是否菜单", notes = "是否菜单")
    private String menu;
    @ApiModelProperty(value = "URL", notes = "URL")
    private String url;
    @ApiModelProperty(value = "图标", notes = "图标")
    private String icon;
    @ApiModelProperty(value = "排序", notes = "排序")
    private String sort;
}
