package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest1 {

	public static void main(String[] args) {
		/* Set 메소드 예제 */
		HashSet<Integer> set = new HashSet<Integer>();
		//add(객체) : set에 객체를 추가
		set.add(10);		set.add(10);
		set.add(5);			set.add(4);
		set.add(8);			set.add(100);
		//size() : set의 크기
		System.out.println("set의 크기 : "+set.size());
		//contains(객체): 객체가 있는지 없는지 확인
		System.out.println("set에 10이 있습니까? " + set.contains(10));
		System.out.println("set에 11이 있습니까? " + set.contains(11));
		//isEmpty() : set이 비었는지 아닌지 확인
		System.out.println("set이 비어있습니까? " + set.isEmpty());
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp+ " ");
		}
		System.out.println();
		//remove(객체) : 객체와 일치하는 내용을 삭제하고 삭제 성공 여부를 알림
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10));
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(101));
		//clear() : 비움
		set.clear();
		System.out.println("set의 크기 : " + set.size());
	}

}
