package day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		//현재시간을 객체로 생성
		Date date = new Date();
		//현재시간을 출력
		System.out.println(date);
		//현재시간을 원하는 형태로 문자열로 변경(Date => String)
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = form.format(date);
		System.out.println(str);
		
		//시간표현으로 된 문자열을 시간 객체로 변경(String => Date)
		String str2 = "2021-05-21 09:50:55";
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2;
		
		try {
			System.out.println(str2);
			date2 = form2.parse(str2);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("예약 정보를 입력하세요.");
		System.out.print("입실일(yyyy년MM월dd일) : ");
		Scanner scan = new Scanner(System.in);
		String startDate = scan.next();
		System.out.print("퇴실일(yyyy년MM월dd일) : ");
		String endDate = scan.next();
		Hotel hotel = new Hotel();
		hotel.setEndDate(endDate);
		hotel.setStartDate(startDate);
		System.out.println(hotel);
		scan.close();
	}
}
class Hotel{
	//입실일
	Date startDate;
	//퇴실일
	Date endDate;
	//다른 정보는 생략
	public String getStartDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");
		String str = form.format(startDate);
		return str;
	}
	public void setStartDate(String startDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");
		
		try {
			this.startDate = form2.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getEndDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");
		String str = form.format(endDate);
		return str;
	}
	public void setEndDate(String endDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");
		
		try {
			this.endDate = form2.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "Hotel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	

}
