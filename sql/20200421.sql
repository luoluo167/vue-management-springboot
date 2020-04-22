drop table if exists sys_department;

drop table if exists sys_log;

drop table if exists sys_permission;

drop table if exists sys_position;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_user;

drop table if exists sys_user_position;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_department                                        */
/*==============================================================*/
create table sys_department
(
   department_id        int(11) not null auto_increment comment '部门ID',
   parent_id            int(11) comment '上级部门ID',
   short_name           varchar(20) comment '简称',
   name                 varchar(50) comment '全称',
   sort                 int(11) comment '排序',
   remark               varchar(255) comment '备注',
   primary key (department_id)
);

alter table sys_department comment '部门';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   log_id               int(11) not null auto_increment comment '日志ID',
   user_id              int(11) comment '用户ID',
   type                 varchar(100) comment '类型',
   create_time          datetime comment '创建时间',
   content              text comment '内容',
   ip                   varchar(100) comment 'IP',
   primary key (log_id)
);

alter table sys_log comment '日志';

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   permission_id        int(11) not null auto_increment comment '权限ID',
   parent_id            int(11) comment '父权限ID',
   name                 varchar(100) comment '名称',
   menu                 bit comment '是否菜单',
   url                  varchar(255) comment 'URL',
   icon                 varchar(100) comment '图标',
   sort                 int(11) comment '排序',
   primary key (permission_id)
);

alter table sys_permission comment '权限';

/*==============================================================*/
/* Table: sys_position                                          */
/*==============================================================*/
create table sys_position
(
   position_id          int(11) not null auto_increment comment '职位ID',
   name                 varchar(50) comment '名称',
   code                 varchar(100) comment '编码',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   status               bit comment '状态(0启用, 1停用)',
   del                  bit comment '删除(0正常, 1删除)',
   primary key (position_id)
);

alter table sys_position comment '职位';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int(11) not null auto_increment comment '角色ID',
   name                 varchar(50) comment '名称',
   sort                 int(11) comment '排序',
   remark               varchar(255) comment '备注',
   primary key (role_id)
);

alter table sys_role comment '角色';

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   role_permission_id   int(11) not null auto_increment comment '角色权限ID',
   role_id              int(11) comment '角色ID',
   permission_id        int(11) comment '权限ID',
   primary key (role_permission_id)
);

alter table sys_role_permission comment '角色权限';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int(11) not null auto_increment comment '用户ID',
   department_id        int(11) comment '部门ID',
   account              varchar(50) comment '登录名',
   name                 varchar(50) comment '姓名',
   password             varchar(100) comment '密码',
   phone                varchar(20) comment '电话',
   admin                bit comment '管理员(0非管理员, 1管理员)',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   last_login_time      datetime comment '最后登录时间',
   login_times          int(11) comment '登录次数',
   status               bit comment '状态(0未启用, 1启用)',
   del                  bit comment '删除状态(0正常, 1删除)',
   primary key (user_id)
);

alter table sys_user comment '用户';

/*==============================================================*/
/* Table: sys_user_position                                     */
/*==============================================================*/
create table sys_user_position
(
   user_position_id     int(11) not null auto_increment comment '用户职位ID',
   user_id              int(11) comment '用户ID',
   position_id          int(11) comment '职位ID',
   primary key (user_position_id)
);

alter table sys_user_position comment '用户职位';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   user_role_id         int(11) not null auto_increment comment '用户角色ID',
   user_id              int(11) comment '用户ID',
   role_id              int(11) comment '角色',
   primary key (user_role_id)
);

alter table sys_user_role comment '用户角色';

alter table sys_department add constraint FK_Reference_1 foreign key (parent_id)
      references sys_department (department_id) on delete restrict on update restrict;

alter table sys_log add constraint FK_Reference_10 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table sys_permission add constraint FK_Reference_7 foreign key (parent_id)
      references sys_permission (permission_id) on delete restrict on update restrict;

alter table sys_role_permission add constraint FK_Reference_8 foreign key (role_id)
      references sys_role (role_id) on delete restrict on update restrict;

alter table sys_role_permission add constraint FK_Reference_9 foreign key (permission_id)
      references sys_permission (permission_id) on delete restrict on update restrict;

alter table sys_user add constraint FK_Reference_2 foreign key (department_id)
      references sys_department (department_id) on delete restrict on update restrict;

alter table sys_user_position add constraint FK_Reference_3 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table sys_user_position add constraint FK_Reference_4 foreign key (position_id)
      references sys_position (position_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_5 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_6 foreign key (role_id)
      references sys_role (role_id) on delete restrict on update restrict;
