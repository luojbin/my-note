# mysql

## 查看所有数据库

> show databases;

## 新建数据库

> create databases 数据库名;

## 删除数据库

> drop database 数据库名;

## 选择切换数据库

> use 数据库名;

## 显示当前数据库中的所有表

> show tables;

# DDL
## 建表

> create table 表名 (字段名 数据类型, 字段名 数据类型);

	create database Demo;
	create table mytable (
		id int,
		name varchar(100)
	);
	insert into mytable values (1,'tom');
	insert into mytable values (2,'jerry');
	select * from mytable;

## 删除表

> drop table 表名

## 设置当前命令行窗口的编码, 设置当前窗口的文本编码为 UTF-8

> set names utf8;

## 执行 SQL 脚本命令
就是执行文本文件中的一批 SQL 命令.
如果文件是UTF-8编码的, 就必须先执行 set names utf8
