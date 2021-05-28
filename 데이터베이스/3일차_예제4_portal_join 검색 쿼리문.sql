-- join은 한 테이블로 원하는 모든 정보를 가져올 수 없을 때 여러 테이블을 하나로 만들어서
-- 가져와야 하는 경우에 사용
-- 2020135001 학생의 수강한 강의 제목을 하나의 테이블로 확인할 수 있다(X)
--  =>수강 테이블에서 2020135001학생이 수강한 강의코드는 확인할 수 있지만 제목은 확인 불가
-- 2020135001 학생의 수강한 강의 코드를 하나의 테이블로 확인할 수 있다(O), 
--  =>수강 테이블에서 확인
-- select 테이블1.속성1, 테이블1.속성2, .. 테이블2.속성1 from 테이블1, 테이블2 where 조건
-- 2020135001 학생의 수강한 강의 제목을 확인하기 위해서 course(수강정보), class(강의제목)
--   테이블이 필요
select co_st_num as '학번', cl_title as '강의명' from course, class 
	where co_cl_code = cl_code and co_st_num = '2020135001';
-- 교수번호가 P2000135001인 교수님의 강의를 들은 학생명단
select st_name from course, class, student 
where co_cl_code = cl_code and co_st_num = st_num and cl_pr_num = 'P2000135001';
-- select 속성1,속성2,.. from 테이블1 join 테이블2 on 테이블1.외래키 = 테이블2.기본키;
-- 위에한 2020135001 학번 학생이 수강한 강의명을 확인하는 코드를 join을 이용하여 확인
select course.co_st_num as'학번', class.cl_title as'강의명' 
from course 
	join class 
		on course.co_cl_code = class.cl_code
			where course.co_st_num= '2020135001';
-- join할 때 두 테이블의 속성명이 겹치지 않는 경우 속성 이름앞에 테이블명을 생략해도 된다
-- 네트워크를 강의하는 교수님 이름을 확인
select pr_name from class
	join professor
		on pr_num = cl_pr_num
			where cl_title = '네트워크';




    