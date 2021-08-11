# 예외 발생시 확인할 내용

- SQL 관련 예외 발생
  1. SQL 쿼리문 문법 확인하기
     - Mapper에 작성한 쿼리문을 워크벤치에 복붙 후 #{}부분에 예시 값을 넣어서 문제가 없는지 확인
     - 테이블 명에 색상이 들어가는지 확인 : like, option같이 키워드가 테이블인 경우 앞뒤로 ``를 해줘야함
  2. DAO에 @Param확인 
     - @Param 붙인거와 안 붙인거는 String이랑 int는 차이가 없지만 VO인 경우는 차이가 있다.
     - @Param을 안붙이면 #{멤버변수명}으로, @Param을 붙이면 #{지정한객체명.멤버변수명}으로 호출

- Dependency 예외 발생
  1. @Autowried나 @AllArgsConstructor 빼먹었는지 확인
  2. @Service 빼먹었는지 확인
  3. servlet-context.xml에 component-scan부분에 패키지명에 .*인지 확인
     예 : <context:component-scan base-package="kr.green.study.*" />

- URL을 못찾을 때 : URL 처리하는 곳을 만들었는데 찾질 못하는 경우(404에러, 405에러)
  1. Cotroller 클래스에 @Controller 빼먹었는지 확인

- 로그인 구현 했는데 ${user.xx}이 안 찍히는 경우
  1. 로그인 유지 기능 구현하면 됨

- DB 기본키 수정 시 안되는 경우 : 타입 수정이나 AI(자동증가 체크) 등
  1. 다른 테이블에 외래키로 지정되어 있으면 안됨 => 외래키 해제 후 변경 => 다시 외래키 지정











