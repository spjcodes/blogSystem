create database if not exists blog;
use blog;
set character_set_server=utf8;
set character_set_database=utf8;
show variables like '%char%';

drop table if exists blog.`articletype`;
create table  if not exists blog.articletype(
    id varchar(64) primary key,
    typeName varchar(20),
    icon     varchar(100),
    totals   integer
    );

drop table if exists blog.blogarticle;
create table if not exists blog.blogarticle (
    title varchar(50)
    ,intro varchar(200)
    ,bolgCover varchar(100)
    ,typeId varchar(100)
    ,content Blob
    ,isComment bit
    ,editType bit
    ,isOriginal bit
    ,createTime timestamp
    ,isUseful integer  -- 觉得用户的用户数
    ,visits integer    -- 访问量
    );

drop table if exists comment;
create table if not exists comment (
    id varchar(64) primary key
    ,articleId varchar(64)
    ,name varchar(200)
    ,content varchar(255)
    );

drop table if exists blog.recommend;
create table if not exists blog.recommend (
    id varchar(64)
    ,articleId varchar(64)
    ,recomid varchar(64)
    ,recomid1 varchar(64)
    ,recomid2 varchar(64)
    );

drop table if exists resumer;
create table if not exists blog.resumer (
    id varchar(64) primary key
    ,isShow bit
    ,contetn varchar(500)
    );


drop table if exists blog.selfIntro;
create table if not exists blog.selfIntro (
    id varchar(64)
    ,intro varchar(200)
    ,icon varchar(100)
    );


drop table if exists blog.t_admin;
create table if not exists blog.t_admin (
    nickName varchar(64)
    ,pwd varchar(32)
    );


drop table if exists blog.user;
create table if not exists blog.user(
    id varchar(64) primary key
    ,pwd varchar(32)
    ,favorite varchar(200)
    ,comments varchar(200)
    ,useful varchar(100)
    );