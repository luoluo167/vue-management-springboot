package com.ljl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.converters.integer.IntegerStringConverter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>日志</p>
 *
 * @author ljl
 * @since 2020-04-22
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 日志ID */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /** 用户ID */
    @TableField("user_id")
    private Integer userId;

    /** 类型 */
    @TableField("type")
    private String type;

    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /** 内容 */
    @TableField("content")
    private String content;

    /** IP */
    @TableField("ip")
    private String ip;


}
