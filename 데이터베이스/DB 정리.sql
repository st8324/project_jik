/* 
요구사항명세서를 통해 ERD 작성하는 과정이 DB 설계
SQL
 - DDL
   - create : 테이블/DB를 생성
   - drop : 테이블/DB를 삭제
   - alter : 테이블/DB를 수정(속성, 제약조건등을 수정)
 - DML (CRUD)
   - insert : 튜플을 추가
   - select : 튜플을 검색
   - update : 튜플을 수정
   - delete : 튜플을 삭제
 - DCL
   - truncate : 테이블을 초기화
- delete와 truncate를 이용하여 전체 튜플을 삭제하는 경우 비교
  - delete를 이용하여 데이터를 삭제하면 auto_increment을 가지는 속성이 있는 경우
    기존 값을 이어서 증가
  - truncate를 이용하여 데이터를 삭제하면 auto_increment을 가지는 속성이 있는 경우
    1부터 시작
  - truncate는 전체를 한번에 삭제하지만 delete를 한행씩 삭제해서 전체를 삭제하기 때문에
    delete가 느림
  - 전체를 초기화 하는 경우 truncate를 이용
  - 일부만 삭제하는 경우 delete를 이용
  
  select [all | distinct] 속성 from 테이블
  [where 조건]
  [group by 속성]
  [having 조건]
  [order by [asc | desc]]
  [limit 시작번지, 갯수 | limit 갯수];
  
  join : 여러 테이블들을 연결하여 원하는 검색을 함
   - 주로 외래키를 이용함
   
   insert into 테이블명[(속성,...,속성)] values(값,...,값) [,(값, ..., 값)];
   update 테이블명 set 속성 = 값 [where 조건];
   delete from 테이블 [where 조건];
   
   키
    - 슈퍼키(유일성) : 튜플을 0개 또는 하나만 검색할 수 있게 하는 속성들
    - 후보키(최소성) : 슈퍼키중에서 필수적인 속성만으로 구성된 키
    - 기본키 : 후보키중에 대표할 수 있도록 선정된 키, primary key
    - 대체키 : 기본키가 되지 못한 후보키, unique
    - 외래키 : 다른 테이블의 기본키값 또는 null 가지는 키
프로시저
 - 메소드처럼 기능을 미리 지정해서 원할 때 직접 호출해서 사용
 
트리거
 - 튜플이 추가/수정/삭제 되었을 때 다른 테이블에 있는 값을 변경할 때 사용
 - 해당 동작이 자동으로 실행되게 할 때 사용
  
    
DB 복습
1. DB 설계(ERD) - 작은 규모의 시스템(과일과게에서 과일 판매시스템)부터 설계하는 연습을 하고,
   이후에 규모가 큰 시스템을 설계하는 연습해야 함
2. 검색 연습 - 원하는 정보를 가져오기 위한 쿼리문 연습
*/




