-- apple 고객이 주문한 가격을 확인
select 주문번호, 주문고객, (수량 * 단가) as '가격' from 주문 
	join 제품
		on 주문제품 = 제품번호
			where 주문고객 = 'apple';
-- 그냥만두가 판매된 갯수를 확인
select 제품명, sum(수량) from 주문 
join 제품
	on 제품번호 = 주문제품
		where 제품명 = '그냥만두';
