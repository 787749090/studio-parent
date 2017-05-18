/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017-5-16 11:41:42                           */
/*==============================================================*/


drop index index_2 on bs_business_info;

alter table bs_business_info
   drop primary key;

drop table if exists bs_business_info;

drop index index_2 on bs_button;

alter table bs_button
   drop primary key;

drop table if exists bs_button;

drop index index_2 on bs_department_info;

alter table bs_department_info
   drop primary key;

drop table if exists bs_department_info;

drop index index_2 on bs_group_rp_role;

alter table bs_group_rp_role
   drop primary key;

drop table if exists bs_group_rp_role;

drop index index_2 on bs_menu;

alter table bs_menu
   drop primary key;

drop table if exists bs_menu;

drop index index_2 on bs_role;

alter table bs_role
   drop primary key;

drop table if exists bs_role;

drop index index_2 on bs_role_rp_button;

alter table bs_role_rp_button
   drop primary key;

drop table if exists bs_role_rp_button;

drop index index_2 on bs_role_rp_menu;

alter table bs_role_rp_menu
   drop primary key;

drop table if exists bs_role_rp_menu;

drop index index_2 on bs_role_rp_tab;

alter table bs_role_rp_tab
   drop primary key;

drop table if exists bs_role_rp_tab;

drop index index_2 on bs_system_info;

alter table bs_system_info
   drop primary key;

drop table if exists bs_system_info;

drop index index_2 on bs_system_log;

alter table bs_system_log
   drop primary key;

drop table if exists bs_system_log;

drop index index_2 on bs_system_menu;

alter table bs_system_menu
   drop primary key;

drop table if exists bs_system_menu;

drop index index_2 on bs_tab;

alter table bs_tab
   drop primary key;

drop table if exists bs_tab;

drop index index_2 on bs_user;

alter table bs_user
   drop primary key;

drop table if exists bs_user;

drop index index_2 on bs_user_group;

alter table bs_user_group
   drop primary key;

drop table if exists bs_user_group;

/*==============================================================*/
/* Table: bs_business_info                                      */
/*==============================================================*/
create table bs_business_info
(
   id                   int not null comment '序号，自增长,主键',
   business_id          varchar(32) not null comment '企业编号',
   business_name        varchar(32) comment '企业名称',
   belong_area          varchar(32) comment '所属辖区',
   tax_authority        varchar(32) comment '企业所得税主管税务机关',
   juridical_person     varchar(12) comment '法人代表',
   tel                  varchar(12) comment '联系电话号码',
   register_address     varchar(100) comment '企业注册地址',
   register_fund        int comment '企业注册资金',
   register_time        date comment '企业注册时间',
   organization_type    int comment '组织形式,0:国有控股，1：股份有限，2：有限责任，3：中外合资，4：外商独资',
   organization_code    varchar(32) comment '组织机构代码',
   logo_url             varchar(100) comment '企业logo信息图片地址',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_business_info comment '记录企业的信息';

alter table bs_business_info
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_business_info
(
   business_id
);

/*==============================================================*/
/* Table: bs_button                                             */
/*==============================================================*/
create table bs_button
(
   id                   int not null comment '序号，自增长，主键',
   button_id            varchar(32) not null comment '按钮编号，唯一性',
   tab_id               varchar(32) not null comment 'tab编号，外键',
   name                 varchar(12) comment '名称',
   value                varchar(32) comment '值',
   css                  varchar(32) comment '样式',
   image                varchar(50) comment '图标',
   tip                  varchar(50) comment '按钮提示信息',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_button comment '按钮表';

alter table bs_button
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_button
(
   button_id
);

/*==============================================================*/
/* Table: bs_department_info                                    */
/*==============================================================*/
create table bs_department_info
(
   id                   int not null comment '序号，自增长，主键',
   department_id        varchar(32) not null comment '部门编号，逻辑主键',
   business_id          varchar(32) not null comment '企业编号',
   department_name      varchar(32) comment '部门名称',
   department_describe  varchar(100) comment '部门描述',
   status               varchar(8) comment '启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_department_info comment '部门信息表';

alter table bs_department_info
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_department_info
(
   department_id
);

/*==============================================================*/
/* Table: bs_group_rp_role                                      */
/*==============================================================*/
create table bs_group_rp_role
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) not null comment '逻辑主键',
   group_id             varchar(32) not null comment '用户组编号',
   role_id              varchar(32) not null comment '角色编号',
   status               varchar(8) comment '用户组启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_group_rp_role comment '用户组与角色关联关系表';

alter table bs_group_rp_role
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_group_rp_role
(
   pid
);

/*==============================================================*/
/* Table: bs_menu                                               */
/*==============================================================*/
create table bs_menu
(
   id                   int not null comment '序号，自增长，主键',
   menu_id              varchar(32) not null comment '菜单编号，逻辑主键',
   parent_menu_id       varchar(32) not null comment '父级菜单编号，若为顶级菜单，则为0',
   menu_name            varchar(18) comment '菜单名称',
   is_leaf              varchar(8) comment '是否为叶子菜单，YES：是，NO不为叶子菜单',
   menu_url             varchar(100) comment '菜单连接地址',
   menu_image           varchar(100) comment '菜单图片连接地址',
   css                  varchar(32) comment '菜单样式',
   menu_tip             varchar(32) comment '菜单提示信息',
   status               varchar(8) comment '用户组启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_menu comment '菜单信息表';

alter table bs_menu
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_menu
(
   menu_id
);

/*==============================================================*/
/* Table: bs_role                                               */
/*==============================================================*/
create table bs_role
(
   id                   int not null comment '序号，自增长，主键',
   role_id              varchar(32) not null comment '角色编号，逻辑主键',
   role_name            varchar(32) not null comment '角色名称',
   role_type            varchar(12) comment '角色类型；PLATFORM-平台角色，SYSTEM-系统角色',
   status               varchar(8) comment '用户组启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息',
   system_id            varchar(32) not null comment '系统编号'
);

alter table bs_role comment '角色信息表';

alter table bs_role
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_role
(
   role_id
);

/*==============================================================*/
/* Table: bs_role_rp_button                                     */
/*==============================================================*/
create table bs_role_rp_button
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) comment '逻辑主键，唯一索引',
   role_id              varchar(32) comment '角色编号，外键',
   button_id            varchar(32) comment '按钮编号，外键',
   menu_id              varchar(32) comment '冗余字段',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_role_rp_button comment '角色与按钮关系';

alter table bs_role_rp_button
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create index index_2 on bs_role_rp_button
(
   pid
);

/*==============================================================*/
/* Table: bs_role_rp_menu                                       */
/*==============================================================*/
create table bs_role_rp_menu
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) not null comment '逻辑主键',
   role_id              varchar(32) not null comment '角色编号',
   menu_id              varchar(32) not null comment '菜单编号',
   status               varchar(8) comment '用户组启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_role_rp_menu comment '角色与菜单关系表';

alter table bs_role_rp_menu
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_role_rp_menu
(
   pid
);

/*==============================================================*/
/* Table: bs_role_rp_tab                                        */
/*==============================================================*/
create table bs_role_rp_tab
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) comment '逻辑主键，唯一索引',
   role_id              varchar(32) comment '角色编号，外键',
   tab_id               varchar(32) comment 'tab编号，外键',
   menu_id              varchar(32) comment '冗余字段',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_role_rp_tab comment '角色与tab关系';

alter table bs_role_rp_tab
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create index index_2 on bs_role_rp_tab
(
   pid
);

/*==============================================================*/
/* Table: bs_system_info                                        */
/*==============================================================*/
create table bs_system_info
(
   id                   int not null comment '序号，自增长，主键',
   system_id            varchar(32) not null comment '系统编号，唯一性校验，逻辑主键',
   super_name           varchar(32) not null comment '超级管理员的登录名',
   super_password       varchar(32) not null comment '超级管理员的密码',
   system_abbreviate    varchar(12) comment '系统缩写',
   company_name         varchar(32) comment '使用者名称',
   company_logo         varchar(100) comment '使用者logo图像地址',
   status               varchar(8) comment '启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_system_info comment '系统基本信息表';

alter table bs_system_info
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_system_info
(
   system_id
);

/*==============================================================*/
/* Table: bs_system_log                                         */
/*==============================================================*/
create table bs_system_log
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) not null comment '逻辑主键',
   operate_name         varchar(12) comment '操作名称',
   operate_person       varchar(32) comment '操作系统的人员',
   operate_ip           varchar(17) comment '操作人员所处的IP地址',
   operate_describe     varchar(100) comment '操作描述',
   create_name          varchar(32) comment '账户创建人',
   create_time          datetime comment '账户创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息',
   system_id            varchar(32) not null comment '系统编号'
);

alter table bs_system_log comment '记录系统用户操作系统的操作信息';

alter table bs_system_log
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_system_log
(
   pid
);

/*==============================================================*/
/* Table: bs_system_menu                                        */
/*==============================================================*/
create table bs_system_menu
(
   id                   int not null comment '序号，自增长，主键',
   pid                  varchar(32) not null comment '逻辑主键',
   menu_id              varchar(32) not null comment '菜单编号',
   status               varchar(8) comment '启用状态，YES，NO',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息',
   system_id            varchar(32) not null comment '系统编号'
);

alter table bs_system_menu comment '系统与菜单的关系表';

alter table bs_system_menu
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_system_menu
(
   pid
);

/*==============================================================*/
/* Table: bs_tab                                                */
/*==============================================================*/
create table bs_tab
(
   id                   int not null comment '序号，自增长，主键',
   tab_id               varchar(32) not null comment 'tab编号，唯一性',
   menu_id              varchar(32) not null comment '菜单编号，外键',
   title                varchar(50) comment 'tab页标题',
   name                 varchar(16) comment '名称',
   css                  varchar(32) comment '样式',
   value                varchar(32) comment '值',
   image                varchar(50) comment '图标',
   tip                  varchar(32) comment 'tab页提示信息',
   tab_describe         varchar(50) comment 'tab页描述信息',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_tab comment 'tab页面表';

alter table bs_tab
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create index index_2 on bs_tab
(
   tab_id
);

/*==============================================================*/
/* Table: bs_user                                               */
/*==============================================================*/
create table bs_user
(
   id                   int not null comment '序号，自增长，主键',
   user_name            varchar(32) not null comment '登录名，逻辑主键',
   group_id             varchar(32) not null comment '用户组编号',
   department_id        varchar(32) comment '部门编号',
   password             varchar(32) not null comment '登录密码',
   true_name            varchar(12) comment '真实姓名',
   nick_name            varchar(32) comment '昵称',
   sex                  varchar(8) comment '性别，M：男，F：女',
   card_id              varchar(18) comment '身份证号',
   job_title            varchar(32) comment '职位名称、级别',
   qq                   varchar(12) comment 'qq号码',
   wechat               varchar(32) comment '微信账号',
   skype                varchar(32) comment 'Skype账号',
   phone                varchar(12) not null comment '移动电话，唯一校验',
   telephone            varchar(12) comment '固定电话',
   email                varchar(32) not null comment '邮箱地址，唯一校验',
   user_address         varchar(100) comment '联系地址',
   post_code            varchar(12) comment '邮政编码',
   head_image           varchar(100) comment '保存头像地址',
   qr_code              varchar(100) comment '二维码图像地址',
   status               varchar(8) comment '启用状态，YES，NO',
   email_is_verif       varchar(8) comment '邮箱校验状态，YES，NO',
   user_type            varchar(16) comment '用户类型，PLATFORM-平台用户，SYSTEM-系统用户',
   login_number         int comment '登录的次数统计',
   last_login_time      datetime comment '最后登录时间',
   password_modify_time datetime comment '密码修改时间',
   password_modify_mode varchar(8) comment '密码修改方式，SELF-自己修改，RESET-重置，CREATE-新建',
   password_error_number int comment '密码错误次数',
   user_lock_time       datetime comment '账户锁定时间',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息'
);

alter table bs_user comment '记录用户的信息';

alter table bs_user
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_user
(
   user_name
);

/*==============================================================*/
/* Table: bs_user_group                                         */
/*==============================================================*/
create table bs_user_group
(
   id                   int not null comment '序号，自增长，主键',
   group_id             varchar(32) not null comment '逻辑主键',
   group_name           varchar(32) not null comment '用户组名',
   status               varchar(8) comment '用户组启用状态，YES，NO',
   group_type           varchar(18) comment '用户组类型；PLATFORM-平台用户组，SYSTEM-系统用户组',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   remark               varchar(200) comment '备注信息',
   system_id            varchar(32) not null comment '系统编号'
);

alter table bs_user_group comment '用户组表关联用户表';

alter table bs_user_group
   add primary key (id);

/*==============================================================*/
/* Index: index_2                                               */
/*==============================================================*/
create unique index index_2 on bs_user_group
(
   group_id
);

