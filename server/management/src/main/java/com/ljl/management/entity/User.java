package com.ljl.management.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户
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
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /** 部门ID */
    @TableField("department_id")
    private Integer departmentId;

    /** 登录名 */
    @TableField("account")
    private String account;

    /** 姓名 */
    @TableField("name")
    private String name;

    /** 密码 */
    @JsonIgnore
    @ExcelIgnore
    @TableField("password")
    private String password;

    /** 电话 */
    @TableField("phone")
    private String phone;

    /** 管理员(0非管理员, 1管理员) */
    @TableField("admin")
    private Boolean admin;

    /** 创建时间 */
    @com.alibaba.excel.annotation.format.DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /** 修改时间 */
    @com.alibaba.excel.annotation.format.DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /** 最后登录时间 */
    @com.alibaba.excel.annotation.format.DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("last_login_time")
    private Date lastLoginTime;

    /** 登录次数 */
    @TableField("login_times")
    private Integer loginTimes = 0;

    /** 状态(0未启用, 1启用) */
    @TableField("status")
    private Boolean status;

    /** 删除状态(0正常, 1删除) */
    @ExcelIgnore
    @JsonIgnore
    @TableField("del")
    @TableLogic
    private Boolean del =false;


}
