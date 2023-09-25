show databases;

create database if not exists  board;

CREATE USER 'aleks'@'localhost' IDENTIFIED BY 'wjqthr12!@';
select `USER` from `mysql`.`user`;
show grants for 'aleks'@'hostname';
grant all on `board`.* to 'aleks'@'localhost' with grant option;


