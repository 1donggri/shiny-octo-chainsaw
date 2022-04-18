package exam01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * Date 클래스
		 * 		- 시스템으로 부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 */
		
		Date date = new Date();
		System.out.println(date);
		
//		System.out.println(date.getDate());
//		System.out.println(date.getMonth() + 1);
//		System.out.println(date.getYear());
//		System.out.println(date.getHours());
		
		System.out.println(String.format("%tY/%tm/%td %tH:%tM:%tS", date, date, date, date, date, date));
		System.out.println(date.getTime());
		
		/*
		 * Calendar 클래스
		 */
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		
		c.add(Calendar.YEAR, 1);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c.getTime()));
		
		c.add(Calendar.MONTH, 13);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c.getTime()));
		
		c.add(Calendar.DATE, 60);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c.getTime()));
		
		c = Calendar.getInstance();
		
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c.getTime()));
		int i = c.getActualMaximum(Calendar.DATE);	// 현재 날짜와 최대 일수
		System.out.println(String.format("%tm 월의 마지막 일은 %d 일", c.getTime(), i));
		
		c.add(Calendar.MONTH, 1);
		i = c.getActualMaximum(Calendar.DATE);	// 현재 날짜와 최대 일수
		System.out.println(String.format("%tm 월의 마지막 일은 %d 일", c.getTime(), i));
		
		c.setTimeZone(TimeZone.getTimeZone("Asia/ToKyo"));
		System.out.println(c.getTime());
		
		/*
		 * GregorianCalendar 클래스
		 * 		- Calendar 클래스를 상속하여 사용하는 클래스
		 */
		
		GregorianCalendar c2 = new GregorianCalendar();
		
		System.out.println(c2.get(Calendar.YEAR));
		System.out.println(c2.get(Calendar.MONTH) + 1);
		System.out.println(c2.get(Calendar.DATE));
		System.out.println(c2.get(Calendar.HOUR));
		System.out.println(c2.get(Calendar.MINUTE));
		System.out.println(c2.get(Calendar.SECOND));
		
		c2.add(Calendar.YEAR, 1);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c2.getTime()));
		
		c2.add(Calendar.MONTH, 13);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c2.getTime()));
		
		c2.add(Calendar.DATE, 60);
		System.out.println(String.format("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS", c2.getTime()));
		
		c2 = new GregorianCalendar();
		System.out.println(c2.isLeapYear(c2.get(Calendar.YEAR)));	// 윤년 확인
		
		c2.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		System.out.println(c2.getTimeZone().getDisplayName());
		
		/*
		 * SimpleDateFormat 클래스
		 * 		- 날짜 포멧 형식을 자유롭게 만들기 위해 사용하는 클래스
		 */
		
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String now = dFormat.format(new Date());
		System.out.println(now);
		
		dFormat.applyPattern("yyyy년 MM월 dd일 HH시 mm분 ss초 .SSS");
		now = dFormat.format(new Date());
		System.out.println(now);
		
		// a (오전)
		dFormat.applyPattern("yyyy년 MM월 dd일 a hh시 mm분 ss초 .SSS");
		now = dFormat.format(new Date());
		System.out.println(now);
		
		// E요일
		dFormat.applyPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초 .SSS");
		now = dFormat.format(new Date());
		System.out.println(now);
		
		dFormat.applyPattern("yyyy년 MM월 dd일");
		try {
			Date d2 = dFormat.parse("2022년 10월 10일");
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 타임존 설정
		TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angelas"));
		
		GregorianCalendar cd1 = new GregorianCalendar();
		System.out.println(cd1.getTime());
		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(cd1.getTime());

	}

}
