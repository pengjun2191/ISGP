/*==============================================================*/
/* Table: p_ps_flow_def                                        */
/*==============================================================*/
create table if not exists p_ps_flow_def
(
    `flow_id` int(11) NOT NULL AUTO_INCREMENT,
    `flow_name`            varchar(200) not null comment '流程名字' ,
    `flow_content`         mediumtext not null comment '流程内容',
    `flow_state`               int(4) not null default 1 comment '是否生效：1在用，0停用',
    primary key (flow_id)
);
/*==============================================================*/
/* Table: p_ps_flow_view                                        */
/*==============================================================*/
create table if not exists p_ps_flow_view
(
    `flow_id`   int(11) NOT NULL comment '流程' ,
    `flow_type_id`  int(11) default null  comment '定义流程内容类型：',
    `cur_node`  varchar(200) default null  comment '当前的方法名和参数，当前节点为字符串null时代表该流程的开始节点',
    `next_node` varchar(200) default null  comment '下一个节点的方法名和参数,非node_def类型可能为空',
    `node_condition` varchar(200) default null comment '进入下一个节点的条件，默认为null，表示没有其它条件时就使用这条规则'
);

/*==============================================================*/
/* Table: p_res_base_fun                                      */
/*==============================================================*/
create table if not exists p_res_base_fun
(
    `fun_id` int(11) NOT NULL AUTO_INCREMENT,
    `fun_name` varchar(200) NOT NULL unique comment '方法名',
    `fun_type_id` int(11) NOT NULL comment '方法所处的阶段,使用res_fun_type表的type_id字段' ,
    `fun_code_type_id` int(11) NOT NULL comment '方法支持的语言类型,使用res_fun_code_type表的code_type_id字段' ,
    `fun_param` varchar(200) NOT NULL comment '方法默认调用参数' ,
    `fun_desc` text NOT NULL comment '方法描述',
    `fun_state` int(4) not null default 1 comment '是否生效：1在用，0停用',
    PRIMARY KEY (`fun_id`)
);

/*==============================================================*/
/* Table: P_SYS_OPTION_DEF                                       */
/*==============================================================*/
create table if not exists P_SYS_OPTION_DEF
(
    `option_id`  int(10) not null comment '选项编号',
    `select_code` int(10) not null comment '类型编码',
    `option_type` int(2) not null comment '选项类型：0：自定义枚举值 1：来源于系统表',
    `option_code` int(10) not null comment '选项枚举值',
    `option_sign` varchar(128) comment '选项标志',
    `option_name` varchar(128) not null comment '选项名称',
    `option_state` int(4) not null comment '是否使用 0：否 1：是',
    `option_sort` int(4) not null comment '选项排序',
    `extend_opti` varchar(100) comment '附加参数',
    `option_desc` varchar(200) comment '描述',
    PRIMARY KEY (`option_id`)
);

/*==============================================================*/
/* Table: p_res_fun_type                                      */
/*==============================================================*/
create table if not exists p_res_fun_type
(
    `type_id` int(11) NOT NULL AUTO_INCREMENT,
    `type_name` varchar(200) NOT NULL unique comment '软件工程阶段包括req,DA,dev,test,ops……',
    `type_desc` text NOT NULL comment '类型描述' ,
    `type_state` int(4) not null default 1 comment '是否生效：1在用，0停用',
    PRIMARY KEY (`type_id`)
);
/*==============================================================*/
/* Table: p_res_fun_code_type                                      */
/*==============================================================*/
create table if not exists p_res_fun_code_type
(
    `code_type_id` int(11) NOT NULL AUTO_INCREMENT,
    `code_type_name` varchar(200) NOT NULL unique comment '支持的语言名称包括python,java,c++,userDef……',
    `code_type_desc` text NOT NULL comment '类型描述' ,
    `code_type_state` int(4) not null default 1 comment '是否生效：1在用，0停用',
    PRIMARY KEY (`code_type_id`)
);

/*==============================================================*/
/* Table: logging_event                                      */
/*==============================================================*/
CREATE TABLE if not exists logging_event
(
    timestmp         BIGINT NOT NULL,
    formatted_message  TEXT NOT NULL,
    logger_name       VARCHAR(254) NOT NULL,
    level_string      VARCHAR(254) NOT NULL,
    thread_name       VARCHAR(254),
    reference_flag    SMALLINT,
    arg0              VARCHAR(254),
    arg1              VARCHAR(254),
    arg2              VARCHAR(254),
    arg3              VARCHAR(254),
    caller_filename   VARCHAR(254) NOT NULL,
    caller_class      VARCHAR(254) NOT NULL,
    caller_method     VARCHAR(254) NOT NULL,
    caller_line       CHAR(4) NOT NULL,
    event_id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

/*==============================================================*/
/* Table: logging_event_property                                      */
/*==============================================================*/
CREATE TABLE  if not exists logging_event_property
(
    event_id       BIGINT NOT NULL,
    mapped_key        VARCHAR(254) NOT NULL,
    mapped_value      TEXT,
    PRIMARY KEY(event_id, mapped_key),
    FOREIGN KEY (event_id) REFERENCES logging_event(event_id)
);

/*==============================================================*/
/* Table: logging_event_exception                                      */
/*==============================================================*/
CREATE TABLE  if not exists logging_event_exception
(
    event_id         BIGINT NOT NULL,
    i                SMALLINT NOT NULL,
    trace_line       VARCHAR(254) NOT NULL,
    PRIMARY KEY(event_id, i),
    FOREIGN KEY (event_id) REFERENCES logging_event(event_id)
);
