create table db_culture.appointment
(
    id            int auto_increment comment '主键' -- 自动递增的主键
        primary key,
    experience_id int null comment '体验',         -- 对应体验的外键
    constraint appointment_id_uindex
        unique (id)                               -- 确保主键唯一
) comment '预约表' engine = InnoDB;               -- 表名为"预约表"，使用 InnoDB 存储引擎


create table db_culture.collection
(
    id            int auto_increment comment '主键'
        primary key,
    experience_id int null comment '体验',
    constraint collection_id_uindex
        unique (id)
) comment '收藏表' engine = InnoDB;


create table db_culture.culture
(
    id         int auto_increment comment '主键'
        primary key,
    city       varchar(20) null comment '地点',     -- 文化遗产所属城市
    code       varchar(5) null comment '编号',      -- 文化遗产编号
    serial     varchar(4) null comment '序号',      -- 序号
    name       varchar(50) null comment '名称',     -- 文化遗产名称
    category   int null comment '类别',             -- 对应的类别 ID
    announce   varchar(20) null comment '公布时间', -- 公布为文化遗产的时间
    type       varchar(10) null comment '类型',     -- 遗产的类型，如物质/非物质
    reporting  varchar(50) null comment '申报地区或单位', -- 申报单位
    protection varchar(50) null comment '保护单位', -- 负责保护的单位
    constraint culture_id_uindex
        unique (id),
    constraint culture_estate_id_fk
        foreign key (category) references db_culture.estate (id) -- 关联遗产类别表
) comment '文化遗产表' engine = InnoDB;


create table db_culture.estate
(
    id       int auto_increment comment '主键'
        primary key,
    category varchar(10) null comment '名称', -- 类别名称
    constraint estate_id_uindex
        unique (id)
) comment '遗产类别表' engine = InnoDB;



create table db_culture.experience
(
    id      int auto_increment
        primary key,
    pic     varchar(255) null comment '图片',    -- 体验活动的相关图片
    title   varchar(255) null comment '标题',   -- 体验活动的标题
    intro   varchar(255) null comment '介绍',   -- 简短的体验活动介绍
    detail  varchar(800) null comment '详情',   -- 详细描述
    address varchar(100) null comment '地址',   -- 体验活动地点
    date    varchar(30) null comment '时间',    -- 活动时间
    phone   varchar(30) null comment '联系电话', -- 联系方式
    constraint experience_id_uindex
        unique (id)
) comment '体验表' engine = InnoDB;


create table db_culture.forum
(
    id     int auto_increment
        primary key,
    pic    varchar(255) null comment '主键', -- 论坛图片（这里注释可能有误）
    title  varchar(255) null comment '标题', -- 帖子的标题
    datail varchar(800) null comment '详情', -- 帖子的详细内容
    date   varchar(20) null comment '时间', -- 发布时间
    constraint forum_id_uindex
        unique (id)
) comment '论坛表' engine = InnoDB;



create table db_culture.survey
(
    id     int auto_increment comment '主键'
        primary key,
    title  varchar(255) null comment '标题',  -- 调研标题
    intro  varchar(255) null comment '介绍',  -- 简短介绍
    detail varchar(800) null comment '详情',  -- 调研详情
    date   varchar(20) null comment '时间',   -- 调研时间
    constraint survey_id_uindex
        unique (id)
) comment '调研表' engine = InnoDB;



create table db_culture.user
(
    id         int auto_increment comment '主键'
        primary key,
    acc        varchar(18) null comment '账号',      -- 用户账号
    pwd        varchar(50) null comment '密码',      -- 用户密码
    pic        varchar(255) null comment '头像',      -- 用户头像
    realname   varchar(50) null comment '真实姓名',   -- 用户真实姓名
    sex        int null comment '性别',              -- 性别（0=女，1=男）
    age        int null comment '年龄',              -- 用户年龄
    address    varchar(100) null comment '收获地址',  -- 收货地址
    postalcode varchar(6) null comment '邮政编码',    -- 邮政编码
    CreateTime varchar(20) null comment '创建时间',   -- 用户注册时间
    constraint user_id_uindex
        unique (id)
) comment '用户表' engine = InnoDB;



