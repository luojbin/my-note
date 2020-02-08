create table t_emp(
  id number(8) primary key,
  name varchar(20),
  age number(3)
);
create sequence t_emp_seq;

create table tt_dept(
  id number(8) primary key,
  deptname varchar2(20),
  addr varchar2(50)
);
create sequence t_dept_seq;