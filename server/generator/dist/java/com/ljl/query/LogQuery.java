package com.ljl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("日志查询条件")
public class LogQuery extends PageQuery {

    @ApiModelProperty(value = "日志ID", notes = "日志ID")
    private String logId;
    @ApiModelProperty(value = "用户ID", notes = "用户ID")
    private String userId;
    @ApiModelProperty(value = "类型", notes = "类型")
    private String type;
    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "内容", notes = "内容")
    private String content;
    @ApiModelProperty(value = "IP", notes = "IP")
    private String ip;
}
