package com.ljl.management.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.management.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户查询条件")
public class UserQuery extends Page<User> {

    @ApiModelProperty(value = "部门ID", notes = "部门ID")
    private Integer departmentId;
    @ApiModelProperty(value = "登录名", notes = "登录名")
    private String account;
    @ApiModelProperty(value = "姓名", notes = "姓名")
    private String name;
    @ApiModelProperty(value = "电话", notes = "电话")
    private String phone;
    @ApiModelProperty(value = "管理员(0非管理员, 1管理员)", notes = "管理员(0非管理员, 1管理员)")
    private Boolean admin;
    @ApiModelProperty(value = "状态(0未启用, 1启用)", notes = "状态(0未启用, 1启用)")
    private Boolean status;
}
