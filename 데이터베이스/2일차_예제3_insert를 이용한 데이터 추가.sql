-- insert 기본 문법
-- insert into 테이블명[(속성명1, 속성명2, ..., 속성명n)]
-- values(값1, 값2, ..., 값n);

-- 테이블명 옆에 속성명들이 생략되면 values에서 값들을 순서대로 넣어주어야 한다

-- student 테이블에 학생 정보 추가
use portal;
-- desc student;
insert into 
	student(st_num, st_id, st_res_num, st_pw, st_dep, st_name)
	values('2020160001', 'abc123', '010527-3456789','abc123','컴공','가나');
-- 위의 insert와 속성 순서가 다른 경우
insert into 
	student(st_id, st_num, st_res_num, st_pw, st_dep, st_name)
	values('abc124', '2020160002', '010528-3456789','abc124','컴공','가다');
-- 테이블명 옆에 속성을 생략한 경우, 학번, 아이디, 주민번호, 비번, 이름, 학과순으로 추가해야한다
insert into student
	values('2020160003','abc','010527-4567890','abc','나다','컴공');

-- 여러 행을 추가하는 경우
insert into student
	values('2020160005','abc789','010527-4567891','abc789','라마가','컴공'),
    ('2020160006','qwe789','010527-4567892','abc789','박씨','컴공');
select * from student;



