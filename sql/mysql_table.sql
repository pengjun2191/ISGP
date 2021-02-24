create table logging_event
(
    timestmp          bigint       not null,
    formatted_message mediumtext   not null,
    logger_name       varchar(254) not null,
    level_string      varchar(254) not null,
    thread_name       varchar(254) null,
    reference_flag    smallint     null,
    arg0              varchar(254) null,
    arg1              varchar(254) null,
    arg2              varchar(254) null,
    arg3              varchar(254) null,
    caller_filename   varchar(254) not null,
    caller_class      varchar(254) not null,
    caller_method     varchar(254) not null,
    caller_line       char(4)      not null,
    event_id          bigint auto_increment
        primary key
);

create table logging_event_exception
(
    event_id   bigint       not null,
    i          smallint     not null,
    trace_line varchar(254) not null,
    primary key (event_id, i),
    constraint logging_event_exception_ibfk_1
        foreign key (event_id) references logging_event (event_id)
);

create table logging_event_property
(
    event_id     bigint       not null,
    mapped_key   varchar(254) not null,
    mapped_value text         null,
    primary key (event_id, mapped_key),
    constraint logging_event_property_ibfk_1
        foreign key (event_id) references logging_event (event_id)
);

create table p_op_carrier
(
    carrier_id      int          not null,
    carrier_name    varchar(200) null comment '运营商中文名',
    carrier_name_es varchar(200) null comment '运营商英文名',
    constraint p_op_carrier_carrier_id_uindex
        unique (carrier_id)
);

alter table p_op_carrier
    add primary key (carrier_id);

create table p_op_country
(
    country_id      int auto_increment
        primary key,
    country_code    varchar(5)  null comment '国家代码',
    country_name    varchar(50) null comment '国家中文名字',
    country_name_es varchar(50) null comment '国家英文名字'
);

create table p_op_cpu
(
    cpu_id          int auto_increment
        primary key,
    cpu_brand       int default 1 null comment 'cpu品牌：1 Intel,2 AMD',
    cpu_type        varchar(50)   null comment 'cpu型号规格',
    cpu_cores       int           null comment '单CPU核心数',
    cpu_bit_width   varchar(50)   null comment 'cpu位数',
    cpu_clock_speed varchar(200)  null comment 'cpu主频（时钟频率）',
    cpu_cache       varchar(50)   null comment 'cpu缓存',
    cpu_fsb         varchar(50)   null comment 'cup总线频率'
);

create table p_op_machine
(
    machine_id            int auto_increment
        primary key,
    machine_name          varchar(200)  null comment '机器名',
    machine_group         int           null comment '机器分组',
    machine_room          int           null comment '机房',
    machine_type          int default 1 null comment '1 实体主机，2 虚拟主机',
    machine_cpu           int           null comment '机器cpu信息',
    machine_cpu_num       int           null comment '机器cpu数量',
    machine_memory        varchar(50)   null comment '机器内存大小',
    machine_disk          varchar(50)   null comment '机器硬盘大小',
    machine_system        int           null comment '机器操作系统信息',
    machine_intranet_ipv4 varchar(50)   null comment '机器内网地址',
    machine_intranet_ipv6 varchar(50)   null comment '机器内网ipv6',
    machine_public_ipv4   varchar(50)   null comment '机器公网地址',
    machine_public_ipv6   varchar(50)   null comment '机器公网地址ipv6',
    machine_domain        varchar(50)   null comment '机器域名',
    machine_state         int default 1 null comment '机器可用状态：0 不可用，1可用'
);

create table p_op_machine_group
(
    group_id   int auto_increment
        primary key,
    group_name varchar(50) null comment '机器分组名',
    group_desc varchar(50) null comment '分组描述'
);

create table p_op_machine_room
(
    room_id          int auto_increment
        primary key,
    room_name        varchar(50)                        null comment '机房名称',
    room_bandwidth   varchar(50)                        null comment '机房带宽',
    room_region      int                                null comment '机房所在城市',
    room_line        int                                null comment '机房线路：1 移动，2联通，3电信，4 双线，5多线，6BGP',
    room_carrier     int                                null comment '机房服务商',
    room_leader      int                                null comment '机房负责人',
    room_modify_date datetime default CURRENT_TIMESTAMP null comment '机房建立时间'
);

create table p_op_os
(
    os_id      int         not null,
    os_name    varchar(50) null comment '系统名称',
    os_type    int         null comment '系统类型:1 Windows,2 DOS,3 Mac OS,4 Unix,5 Linux,6 Google Chrome OS,7 Android,8 Other',
    os_version varchar(50) null comment '系统版本',
    constraint p_op_os_os_id_uindex
        unique (os_id)
);

alter table p_op_os
    add primary key (os_id);

create table p_op_province
(
    province_id      int auto_increment
        primary key,
    province_code    varchar(5)  null comment '省份编码',
    province_name    varchar(50) null comment '省份名称',
    province_name_es varchar(50) null comment '省份英文名称',
    country_id       int         null
);

create table p_op_region
(
    region_id      int auto_increment
        primary key,
    region_code    varchar(5)  null comment '地区编码',
    region_name    varchar(50) null comment '地区名称',
    region_name_es varchar(50) null comment '地区英文名称',
    province_id    int         null
);

create table p_op_release
(
    release_id        int auto_increment
        primary key,
    release_name      varchar(50)                        null comment '发布名称',
    release_milestone int      default 0                 null comment '是否里程碑，0 否，1 是',
    release_version   varchar(50)                        null comment '发布版本',
    release_date      datetime default CURRENT_TIMESTAMP null comment '发布时间',
    release_state     int      default 0                 null comment '发布状态：0 准备发布，1 正常发布 2已停止',
    release_desc      varchar(200)                       null comment '发布描述',
    release_enclosure varchar(200)                       null comment '发布附件路径'
);

create table p_op_release_plan
(
    plan_id         int auto_increment
        primary key,
    plan_name       varchar(200)                       null comment '计划名称',
    plan_desc       varchar(2000)                      null comment '计划描述',
    plan_leader     int                                null comment '计划负责人',
    plan_start_date datetime default CURRENT_TIMESTAMP null comment '计划开始时间',
    plan_end_date   datetime default CURRENT_TIMESTAMP null comment '计划结束时间',
    plan_executive  int                                null comment '计划执行人员',
    plan_product    varchar(1000)                      null comment '计划发布的产品'
);

create table p_op_scripts
(
    script_id      int auto_increment
        primary key,
    script_name    varchar(200)  null comment '脚本名称',
    script_path    varchar(500)  null comment '脚本路径',
    script_state   int default 1 null comment '脚本状态，0 失效，1生效',
    script_content text          null comment '脚本内容',
    script_desc    varchar(2000) null comment '脚本描述'
);

create table p_op_service
(
    service_id            int auto_increment
        primary key,
    service_name          varchar(200)  null comment '服务名称',
    service_edition       varchar(10)   null comment '服务版本',
    service_dept          int           null comment '服务负责部门',
    service_dev           int           null comment '服务开发负责人',
    service_tester        int           null comment '服务测试负责人',
    service_op            int           null comment '服务运维负责人',
    service_machine_group int           null comment '服务所在主机组',
    service_machine       int           null comment '服务所在主机',
    service_desc          varchar(2000) null comment '服务描述'
);

create table p_op_storage
(
    storage_id   int auto_increment
        primary key,
    storage_name varchar(50) null comment '存储名称',
    storage_type int         null comment '1 内存，2 共享内存，3 本地存储，4共享存储，5虚拟缓存',
    storage_size int         null comment '存储大小'
);

create table p_pm_project
(
    project_id         int           null comment '项目id',
    project_name_es    varchar(128)  null comment '英文项目名称',
    project_name_zh    varchar(128)  null comment '中文项目名称',
    project_manager_id varchar(255)  null comment '项目经理，用户id',
    project_desc       varchar(4000) null
);

create table p_ps_flow_def
(
    flow_id          int auto_increment
        primary key,
    flow_name        varchar(200)                       not null comment '流程名字',
    flow_content     mediumtext                         not null comment '流程内容',
    flow_state       int      default 1                 not null comment '是否生效：1在用，0停用',
    modified_by_user varchar(255)                       null comment '流程修改人员',
    modified_date    datetime default CURRENT_TIMESTAMP not null comment '流程修改时间'
);

create table p_ps_flow_view
(
    flow_id          int                                not null comment '流程',
    flow_type_id     int                                null comment '定义流程内容类型：',
    cur_node         varchar(200)                       null comment '当前的方法名和参数，当前节点为字符串null时代表该流程的开始节点',
    next_node        varchar(200)                       null comment '下一个节点的方法名和参数,非node_def类型可能为空',
    node_condition   varchar(200)                       null comment '进入下一个节点的条件，默认为null，表示没有其它条件时就使用这条规则',
    flow_content     varchar(255)                       null,
    flow_name        varchar(255)                       null,
    flow_state       smallint                           null,
    modified_date    datetime default CURRENT_TIMESTAMP null,
    modified_by_user varchar(255)                       null
);

create table p_res_base_fun
(
    fun_id         int auto_increment
        primary key,
    fun_name       varchar(200)  not null comment '方法名',
    fun_typeid     int           not null comment '方法所处的阶段,使用res_fun_type表的type_id字段',
    fun_codetypeid int           not null comment '方法支持的语言类型,使用res_fun_code_type表的code_type_id字段',
    fun_param      varchar(200)  not null comment '方法默认调用参数',
    fun_desc       text          not null comment '方法描述',
    fun_state      int default 1 not null comment '是否生效：1在用，0停用',
    constraint fun_name
        unique (fun_name)
);

create table p_res_fun_code_type
(
    code_type_id    int auto_increment
        primary key,
    code_type_name  varchar(200)  not null comment '支持的语言名称包括python,java,c++,usedef……',
    code_type_desc  text          not null comment '类型描述',
    code_type_state int default 1 not null comment '是否生效：1在用，0停用',
    constraint code_type_name
        unique (code_type_name)
);

create table p_res_fun_type
(
    type_id    int auto_increment
        primary key,
    type_name  varchar(200)  not null comment '软件工程阶段包括req,DA,dev,test,ops……',
    type_desc  text          not null comment '类型描述',
    type_state int default 1 not null comment '是否生效：1在用，0停用',
    constraint type_name
        unique (type_name)
);

create table p_sys_company
(
    company_id        int auto_increment comment '公司id'
        primary key,
    company_name      varchar(200) null comment '公司中文名称',
    company_name_es   varchar(200) null comment '公司英文名称',
    company_telephone varchar(30)  null comment '公司电话',
    company_fax       varchar(30)  null comment '公司传真',
    company_address   varchar(200) null comment '公司地址',
    company_website   varchar(200) null comment '公司官网',
    company_intranet  varchar(200) null comment '公司内网'
);

create table p_sys_company_dept
(
    cd_id      int auto_increment
        primary key,
    company_id int null,
    dept_id    int null
);

create table p_sys_dept
(
    dept_id        int auto_increment comment '部门编号'
        primary key,
    dept_name      varchar(200) null comment '部门名称',
    dept_parent_id int          null comment '上级部门',
    dept_leader    int          null comment '部门负责人'
);

create table p_sys_dept_users
(
    du_id   int auto_increment
        primary key,
    user_id int null,
    dept_id int null
);

create table p_sys_menu
(
    menu_id        int auto_increment comment '菜单id'
        primary key,
    menu_name_es   varchar(128)  null comment '英文菜单',
    menu_name_zh   varchar(128)  null comment '中文菜单',
    menu_path      varchar(128)  null comment '路由地址路径',
    menu_icon      varchar(128)  null comment '菜单图标地址名称',
    menu_component varchar(128)  null comment '组件名，用于解析路由对应的组件',
    menu_parent_id int           null comment '父菜单id',
    menu_status    int default 0 not null
)
    comment '页面菜单表';

create table p_sys_option_def
(
    option_id    int          not null comment '选项编号'
        primary key,
    select_code  int          not null comment '类型编码',
    option_type  int          not null comment '选项类型：0：自定义枚举值 1：来源于系统表',
    option_code  int          not null comment '选项枚举值',
    option_sign  varchar(128) null comment '选项标志',
    option_name  varchar(128) not null comment '选项名称',
    option_state int          not null comment '是否使用 0：否 1：是',
    option_sort  int          not null comment '选项排序',
    extend_opti  varchar(100) null comment '附加参数',
    option_desc  varchar(200) null comment '描述'
);

create table p_sys_role_menus
(
    rm_id   int auto_increment comment '角色权限id'
        primary key,
    role_id int null comment '角色id',
    menu_id int null comment '菜单id'
)
    comment '角色对应的菜单权限';

create table p_sys_roles
(
    role_id      int auto_increment
        primary key,
    role_name_es varchar(128) null comment '英文名称',
    role_name_zh varchar(128) null comment '角色中文名称'
)
    comment '角色表';

create table p_sys_user
(
    user_id          int auto_increment comment '用户id'
        primary key,
    user_name        char(255)                           null comment '用户名',
    user_password    varchar(255)                        null comment '用户密码',
    user             varchar(255)                        null comment '实际的用户名字',
    user_salt        bigint                              null comment '密码盐值',
    user_phone       varchar(255)                        null comment '用户联系方式',
    user_address     varchar(255)                        null comment '用户地址',
    user_email       varchar(255)                        null comment '用户电子邮件',
    user_auth_type   char(255)                           null,
    user_auth_number varchar(255)                        null,
    user_age         int                                 null comment '用户年龄',
    user_create_date timestamp default CURRENT_TIMESTAMP not null,
    user_status      int       default 1                 null
)
    comment '用户表';

create table p_sys_user_bw_list
(
    bw_type          int      default 1                 null comment '0黑名单，1白名单',
    bw_name          varchar(50)                        null comment '黑白名单名称',
    bw_desc          varchar(1000)                      null comment '黑白名单描述',
    bw_menu          int                                null comment '生效的菜单或者模块，操作',
    bw_by_user_id    int                                null comment '黑白名单由哪个用户创建',
    bw_state         int      default 1                 null comment '0禁用，1启用',
    bw_modified_time datetime default CURRENT_TIMESTAMP null comment '创建/修改时间'
);

create table p_sys_user_roles
(
    ur_id   int auto_increment
        primary key,
    user_id int null comment '用户id',
    role_id int null comment '角色id'
)
    comment '用户与角色对应表';

