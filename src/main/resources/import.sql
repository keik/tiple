create table user (
       id            varchar(32)     not null,
       password      varchar(128)    not null,
       enabled       tinyint         not null default 1,
       constraint pk_user primary key (id)
);

create table user_role (
       id            varchar(32)         not null,
       role          varchar(32)         not null,
       constraint pk_user_role primary key (id)
);

insert into user values('test', 'ptest', 1);
insert into user_role values('test', 'USER');
commit;
