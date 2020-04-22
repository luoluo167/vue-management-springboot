package com.ljl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * <p>部门</p>
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
@TableName("sys_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 部门ID */
    @TableId(value = "department_id", type = IdType.AUTO)
    private Integer departmentId;

    /** 上级部门ID */
    @TableField("parent_id")
    private Integer parentId;

    /** 简称 */
    @TableField("short_name")
    private String shortName;

    /** 全称 */
    @TableField("name")
    private String name;

    /** 排序 */
    @TableField("sort")
    private Integer sort;

    /** 备注 */
    @TableField("remark")
    private String remark;


}
