package com.ljl.management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author tianlihu
 * @since 2020-04-13
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 权限ID */
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    /** 父权限ID */
    @TableField("parent_id")
    private Integer parentId;

    /** 名称 */
    @TableField("name")
    private String name;

    /** 是否菜单 */
    @TableField("menu")
    private Boolean menu;

    /** URL */
    @TableField("url")
    private String url;

    /** 图标 */
    @TableField("icon")
    private String icon;

    /** 排序 */
    @TableField("sort")
    private Integer sort;


}
