-- use test;
-- test1 테이블이 존재하면 test1 테이블을 삭제
drop table if EXISTS test1;
create table  test1(
	t_num int,
    t_name varchar(20),
    primary key(t_num)
);
-- show tables;
-- drop table test1;
-- show tables;
-- drop database test;