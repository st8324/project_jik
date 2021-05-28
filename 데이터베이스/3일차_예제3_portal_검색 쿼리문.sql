-- 컴퓨터 학과의 교수님 수를 확인
-- use portal;
select count(*) from professor where pr_dep = '컴퓨터';
select count(*) from professor where pr_dep = '컴퓨터' group by pr_dep;
-- P2002140001인 교수님의 강의하는 강의 리스트 확인
select * from class where cl_pr_num = 'P2002140001';
-- 학점이 2학점이상인 강의리스트 확인
select * from class where cl_point >= 2;
-- 월요일에 수업하는 강의 리스트 확인
select * from class where cl_schedule like '%월%';
-- 2020학번 학생들을 확인
select * from student where st_num like '2020%';
-- 2020135001 학생이 2021MSC004 강의를 수강했을 때 사용해야 하는 쿼리문
-- desc course;
-- insert into course(co_st_num, co_cl_code) values('2020135001','2021MSC004');
select * from course;
-- 2020135001 학번 학생이 수강한 강의 수 확인
select count(*) as '수강한 강의 수' from course where co_st_num = '2020135001';
-- 2020135001 학번 학생이 2021년도에 수강한 강의수 확인
select count(*) as '2021년도 수강한 강의 수' from course 
	where co_st_num = '2020135001' and co_cl_code like '2021%';


