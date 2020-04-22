package com.ljl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("职位查询条件")
public class PositionQuery extends PageQuery {

    @ApiModelProperty(value = "职位ID", notes = "职位ID")
    private String positionId;
    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;
    @ApiModelProperty(value = "编码", notes = "编码")
    private String code;
    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "修改时间", notes = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "状态(0启用, 1停用)", notes = "状态(0启用, 1停用)")
    private String status;
    @ApiModelProperty(value = "删除(0正常, 1删除)", notes = "删除(0正常, 1删除)")
    private String del;
}
