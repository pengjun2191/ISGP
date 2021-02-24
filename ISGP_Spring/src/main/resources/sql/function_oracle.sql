/*==============================================================*/
/* Table: p_ps_flow_def                                       */
/*==============================================================*/
create table p_ps_flow_def
(
    flow_id              NUMBER(11)        not null,
    flow_name           VARCHAR2(200)        not null,
    flow_content         LONG                 not null,
    flow_state                NUMBER(4)            default 1 not null,
    constraint PK_PS_flow_id primary key (flow_id)
);
comment on table p_ps_flow_def is
    '网元流程配置';
comment on column p_ps_flow_def.flow_id is
    '流程id,同名squence创建使用';
comment on column p_ps_flow_def.flow_name is
    '流程名，配制在PS_FLOW_CONFIG表中';
comment on column p_ps_flow_def.flow_content is
    '流程内容';
comment on column p_ps_flow_def.flow_state is
    '是否启用';

/*==============================================================*/
/* Table: p_ps_flow_view                                       */
/*==============================================================*/
create table p_ps_flow_view
(
    flow_id              NUMBER(11)        not null,
    flow_type_id              NUMBER(11)        default null,
    cur_node           VARCHAR2(200)        default null,
    next_node           VARCHAR2(200)        default null,
    node_condition           VARCHAR2(200)        default null

);
comment on table p_ps_flow_view is
    '流程详细展示';
comment on column p_ps_flow_view.flow_id is
    '流程id';
comment on column p_ps_flow_view.flow_type_id is
    '定义流程内容类型';
comment on column p_ps_flow_view.cur_node is
    '当前的方法名和参数，当前节点为字符串null时代表该流程的开始节点';
comment on column p_ps_flow_view.next_node is
    '下一个节点的方法名和参数，非node_def类型可能为空';
comment on column p_ps_flow_view.node_condition is
    '进入下一个节点的条件，默认为null，表示没有其它条件时就使用这条规则';

/*==============================================================*/
/* Table: P_SYS_OPTION_DEF                                       */
/*==============================================================*/
create table P_SYS_OPTION_DEF
(
    option_id   NUMBER(10) not null,
    select_code NUMBER(10) not null,
    option_type NUMBER(2) not null,
    option_code NUMBER(10) not null,
    option_sign VARCHAR2(128),
    option_name VARCHAR2(128) not null,
    option_state NUMBER(4) not null,
    option_sort NUMBER(4) not null,
    extend_opti VARCHAR2(100),
    option_desc        VARCHAR2(200)
);
-- Add comments to the table
comment on table P_SYS_OPTION_DEF
    is '类型枚举表';
-- Add comments to the columns
comment on column P_SYS_OPTION_DEF.option_id
    is '选项编号';
comment on column P_SYS_OPTION_DEF.select_code
    is '类型编码';
comment on column P_SYS_OPTION_DEF.option_type
    is '选项类型：
0：自定义枚举值
1：来源于系统表';
comment on column P_SYS_OPTION_DEF.option_code
    is '选项枚举值';
comment on column P_SYS_OPTION_DEF.option_sign
    is '常量标识

正对选项类型为系统表的有效';
comment on column P_SYS_OPTION_DEF.option_name
    is '选项中文';
comment on column P_SYS_OPTION_DEF.option_state
    is '是否使用
0：否
1：是';
comment on column P_SYS_OPTION_DEF.option_sort
    is '选项排序';
comment on column P_SYS_OPTION_DEF.extend_opti
    is '附加参数';
comment on column P_SYS_OPTION_DEF.option_desc
    is '描述';

/*==============================================================*/
/* Table: p_res_base_fun                                       */
/*==============================================================*/
create table p_res_base_fun
(
    fun_id                 NUMBER(11)        not null,
    fun_name            VARCHAR2(200)        not null,
    fun_typeid          NUMBER(11)                not null,
    fun_codetypeid      NUMBER(11)                not null,
    fun_param           VARCHAR2(200)        not null,
    fun_desc            VARCHAR2(200)        not null,
    fun_state           NUMBER(4)            default 1 not null,
    constraint pk_res_fun_id primary key (fun_id)
);
comment on table p_res_base_fun is
    '基础方法';
comment on column p_res_base_fun.fun_id is
    '方法id，同名squence创建使用';
comment on column p_res_base_fun.fun_name is
    '方法名';
comment on column p_res_base_fun.fun_typeid is
'方法所处的阶段,使用res_fun_type表的type_id字段';
comment on column  p_res_base_fun.fun_codetypeid is
'方法支持的语言类型,使用res_fun_code_type表的code_type_id字段';
comment on column p_res_base_fun.fun_param is
    '方法默认调用参数';
comment on column p_res_base_fun.fun_desc is
    '方法描述';
comment on column p_res_base_fun.fun_state is
    '是否启用';


/*==============================================================*/
/* Table: res_fun_type                                       */
/*==============================================================*/
create table res_fun_type
(
    type_id                 NUMBER(11)        not null,
    type_name            VARCHAR2(200)        not null,
    type_desc            VARCHAR2(200)        not null,
    type_state           NUMBER(4)            default 1 not null,
    constraint pk_res_type_id primary key (type_id)
);
comment on table res_fun_type is
    '自动阶段';
comment on column res_fun_type.type_id is
    '阶段id，同名squence创建使用';
comment on column res_fun_type.type_name is
    '阶段包括req,DA,dev,test,ops……';
comment on column res_fun_type.type_desc is
    '阶段描述';
comment on column res_fun_type.type_state is
    '是否启用';


/*==============================================================*/
/* Table: res_fun_code_type                                       */
/*==============================================================*/
create table res_fun_code_type
(
    code_type_id                 NUMBER(11)        not null,
    code_type_name            VARCHAR2(200)        not null,
    code_type_desc            VARCHAR2(200)        not null,
    code_type_state           NUMBER(4)            default 1 not null,
    constraint pk_res_code_type_id primary key (code_type_id)
);
comment on table res_fun_code_type is
    '支持语言类型';
comment on column res_fun_code_type.code_type_id is
    '语言id，同名squence创建使用';
comment on column res_fun_code_type.code_type_name is
    '支持的语言名称包括python,java,c++,usedef……';
comment on column res_fun_code_type.code_type_desc is
    '语言描述';
comment on column res_fun_type.type_state is
    '是否启用';

create sequence flow_id
    minvalue 1  --增长最小值
    maxvalue 9999999999  --增长最大值,也可以设置NOMAXvalue -- 不设置最大值
    start with 1  --从101开始计数
    increment by 1  --自增步长为1
    cache 50  --设置缓存cache个序列，如果系统down掉了或者其它情况将会导致序列不连续，也可以设置为---NOCACHE防止跳号
    cycle;  --循环,当达到最大值时,不是从start with设置的值开始循环。而是从1开始循环

create sequence fun_id
    minvalue 1  --增长最小值
    maxvalue 9999999999  --增长最大值,也可以设置NOMAXvalue -- 不设置最大值
    start with 1  --从101开始计数
    increment by 1  --自增步长为1
    cache 50  --设置缓存cache个序列，如果系统down掉了或者其它情况将会导致序列不连续，也可以设置为---NOCACHE防止跳号
    cycle;  --循环,当达到最大值时,不是从start with设置的值开始循环。而是从1开始循环

create sequence type_id
    minvalue 1  --增长最小值
    maxvalue 9999999999  --增长最大值,也可以设置NOMAXvalue -- 不设置最大值
    start with 1  --从101开始计数
    increment by 1  --自增步长为1
    cache 50  --设置缓存cache个序列，如果系统down掉了或者其它情况将会导致序列不连续，也可以设置为---NOCACHE防止跳号
    cycle;  --循环,当达到最大值时,不是从start with设置的值开始循环。而是从1开始循环

create sequence code_type_id
    minvalue 1  --增长最小值
    maxvalue 9999999999  --增长最大值,也可以设置NOMAXvalue -- 不设置最大值
    start with 1  --从101开始计数
    increment by 1  --自增步长为1
    cache 50  --设置缓存cache个序列，如果系统down掉了或者其它情况将会导致序列不连续，也可以设置为---NOCACHE防止跳号
    cycle;  --循环,当达到最大值时,不是从start with设置的值开始循环。而是从1开始循环