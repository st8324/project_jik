/* 
SQL - DDL, DML, DCL
DDL - create, alter, drop
DML(CRUD) - insert, select, update, delete
insert into 테이블명[(속성1,속성2,...,속성n)]
	values(값1, 값2, ..., 값n)[, (값1, 값2, ..., 값n)];
select [all | distinct] 속성1,속성2,..,속성n from 테이블
	[where 조건]
    [group by 속성 [having 조건]]
    [order by 속성 [desc | asc]];
update 테이블명
	set
		속성명1 = 값1,
        속성명2 = 값2,
        ...,
        속성명3 = 값3
	[where 조건];
- update문은 조건이 없으면 모든 튜플에 대해 수정을 적용
- update문에 조건절을 생략하거나 조건절이 기본키에 대한 조건이 아니면
  mysql 워크벤치에서는 안정성을 위해 update문을 실행하지 않음. 
  실행하려면 워크벤치 기본 설정을 변경(Edit > Preference > SQL Editor)
  단, 워크벤치가 아닌 MySQL 8.0 Command Like Client로 접속해서 해당 쿼리를 실행하면
  설정에 상관없이 실행 됨
delete from 테이블명 [where 조건];
- 해당 조건을 만족하는 튜플을 삭제
- 조건이 생략되면 전체 튜플을 삭제
*/
-- P2000135001 교수님의 이름을 고길동으로 수정
update professor set pr_name = '고길동' where pr_num = 'P2000135001';
select * from professor;

create table if not exists board(
	bd_num int auto_increment,
    bd_title varchar(50) not null,
    bd_is_del char(1) not null default 'N',
    primary key(bd_num)
);
-- 게시글 5개 등록
insert into board(bd_title) 
	values('제목1'),('제목2'),('제목3'),('제목4'),('제목5');
-- 1번 게시글 삭제
update board set bd_is_del = 'Y' where bd_num = 1;
-- 삭제되지 않은 게시글 검색
select * from board where bd_is_del = 'N';


