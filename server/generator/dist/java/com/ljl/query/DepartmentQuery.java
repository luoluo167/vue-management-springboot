package com.ljl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("部门查询条件")
public class DepartmentQuery extends PageQuery {

    @ApiModelProperty(value = "部门ID", notes = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "上级部门ID", notes = "上级部门ID")
    private String parentId;
    @ApiModelProperty(value = "简称", notes = "简称")
    private String shortName;
    @ApiModelProperty(value = "全称", notes = "全称")
    private String name;
    @ApiModelProperty(value = "排序", notes = "排序")
    private String sort;
    @ApiModelProperty(value = "备注", notes = "备注")
    private String remark;
}
