/* 
사원들의 월급을 관리하는 시스템을 위한 DB를 설계하세요.
직급
- 사원, 대리, 과장, 부장, 전무, 이사
월급
- 월급은 직급별 기본급에 직급별 호봉에 따른 추가금

예> 사원 기본급 200만, 호봉별 추가금이 10만원
     2년차 사원 홍길동의 월급은? 220만원

- 호봉이나 직급이 변경되면 월급이 변경되는 프로시저를
  만드세요.

- 트리거는 추가/변경된 행의 정보를 수정할 수 없다
  =>프로시저 이용
*/

create database if not exists company2;
use company2;

create table if not exists salary(
	sa_level char(2) not null, 
    em_base_salary int not null default 0,
    em_add_salary int not null default 0,
    primary key(sa_level)
);

create table if not exists employee(
	em_num int not null auto_increment,
    em_name varchar(15) not null,
    em_sa_level char(2) not null, 
    em_year int not null default 1,
    em_salary int not null default 0,
    primary key(em_num),
    foreign key(em_sa_level) references salary(sa_level)
);

create table if not exists payments(
	pa_num int not null auto_increment,
    pa_em_num int not null,
    pa_date datetime default current_timestamp,
    pa_price int not null,
    primary key(pa_num),
    foreign key(pa_em_num) references employee(em_num)
);

insert into salary 
	values('사원', 200, 10),('대리', 220, 15),('과장', 240, 20),('부장', 280, 25)
    ,('전무', 300, 30),('이사', 350, 35);
    
insert into employee
	values(1, '홍길동', '사원', 2, 220);
-- 직원의 직급이 변경되는 경우 실행하는 프로시저
drop procedure if exists update_level;
delimiter //
create procedure update_level(
    
)
begin
	
end //
delimiter ;
call update_level();
