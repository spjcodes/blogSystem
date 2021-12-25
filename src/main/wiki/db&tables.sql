create database blog;
use blog;

drop table if exists blog.`dual`;
create table  if not exists blog.dual(
    id varchar(64) primary key describe(),
    typeName varchar(20),
    icon     varchar(100),
    totals   integer
    );