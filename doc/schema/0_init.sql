drop table if exists account;

create table account (
    id int unsigned auto_increment,
    name varchar(50) not null comment '用户名',
    create_time timestamp not null default now() comment '创建时间',
    primary key(id),
    index idx_name(name)
) engine=InnoDB default charset utf8 comment '帐户表';
