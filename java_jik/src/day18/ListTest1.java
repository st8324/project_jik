package day18;

import java.util.ArrayList;

public class ListTest1 {

	public static void main(String[] args) {
		//제네릭 클래스 : 멤버 변수/메소드의 타입이 객체를 생성할 때 결정되는 클래스
		//제네릭 클래스는 타입을 클래스로 해야 한다. 일반 변수 x
		ArrayList<String> list = new ArrayList<String>();
		//add() : 리스트에 추가
		for(int i = 0; i<10; i++) {
			list.add("학원 출근");
		}
		list.add("수업");//리스트가 꽉차면 자동으로 크기를 늘린다.
		//get(번지) : 번지에 있는 값을 가져옴
		System.out.println(list.get(10));
		System.out.println("리스트 크기 : " + list.size());
		//add(번지, 값) : 번지에 값을 추가
		list.add(10,"아침식사");
		System.out.println(list.get(10));
		System.out.println("리스트 크기 : " + list.size());
		//set(번지, 값) : 번지에 값을 설정(덮어쓰기)
		list.set(10, "간식");
		System.out.println(list.get(10));
		System.out.println("리스트 크기 : " + list.size());
		//indexOf(값) : 값이 리스트에 있는지 없는지 확인하여 있으면 번지를 없으면 -1
		//				를 반환. 해당 클래스의 equals()를 호출하여 같은지를 확인
		System.out.println("리스트에 간식은 "+list.indexOf("간식") + "번지");
		System.out.println("리스트에 저녁은 "+list.indexOf("저녁") + "번지");
		//contains(값) : 값이 리스트에 있는지 없는지 확인하여 알려주는 메소드,
		//				equals()를 이용
		System.out.println("리스트에 간식이 있다? "+list.contains("간식"));
		System.out.println("리스트에 저녁이 있다? "+list.contains("저녁"));
		//clear() : 리스트를 비움
		list.clear();
		System.out.println("리스트 크기 : " + list.size());
		//isEmpty() : 리스트가 비어있는지 알려주는 메소드
		System.out.println("리스트가 비어 있습니까? " + list.isEmpty());
		list.add("출근");
		list.add("준비");
		list.add("수업");
		list.add("점심");
		//remove(번지) : 해당 번지의 값을 제거
		//remove(값)   : 값과 일치하는 내용을 제거
		System.out.println("리스트 0번지 : " + list.get(0));
		list.remove(0);
		System.out.println("리스트 0번지 : " + list.get(0));
		list.remove("준비");
		System.out.println("리스트 0번지 : " + list.get(0));
	}
}
