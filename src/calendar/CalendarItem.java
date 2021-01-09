package calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;

public class CalendarItem {

	public static int[] MONTH_OF_MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public CalendarItem() {

	}

	public static int[] getTodaysCalendar(int year, int month) {
		int[] ym = new int[2];
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		ym[0] = year;
		month = cal.get(Calendar.MONTH) + 1;
		ym[1] = month;
		return ym;

	}

	public static void getLeapdays(int year) {
		int february = 28;
		if (year % 4 == 0) {
			february = 29;
			if (year % 100 == 0) {
				february = 28;
				if (year % 400 == 0) {
					february = 29;
				}
			}
		}
		MONTH_OF_MAX_DAYS[1] = february;
	}

	public static int getWeekday(int year, int month) {
		year--;
		int week = 1;
		week = 1 + ((year + year / 4 - year / 100 + year / 400) % 7);
		if (month != 1) {
			for (int i = 0; i < month - 1; i++) {
				week = (week + (CalendarItem.MONTH_OF_MAX_DAYS[i] % 7)) % 7;
			}
		}
		return week;
	}
	
	public static void printCalendar(int year, int month, ArrayList<Integer> eventDate)throws IOException {
		getLeapdays(year); // 윤년 계산
		int week = getWeekday(year, month); // 1일 요일 계산
		includeEvent(year, month, eventDate); // 일정있는 날짜 표시 
		print(year, month, week, eventDate); // 달력 출력
		eventDate.clear();
	}

	public static void print(int year, int month, int week, ArrayList<Integer> eventDate) throws IOException {
		System.out.printf("     <<%4d %2d>>", year, month);
		System.out.println();
		System.out.println("SU\tMO\tTU\tWE\tTH\tFR\tSA");
		System.out.println(" -------------------------------------------------");
		for (int i = 0; i < week; i++) {
			System.out.printf("  \t");
		}
		for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
			System.out.print(i);
			for (int j = 0; j < eventDate.size(); j++) {
				if (i == eventDate.get(j)) {
					System.out.printf(".");
				}
			}
			System.out.print("\t");
			if ((i + week) % 7 == 0) {
				System.out.println();
			}

		}
		System.out.println();
	}

	public static void includeEvent(int year, int month, ArrayList<Integer> eventDate) throws IOException {
		String[] dateSplit = new String[3];
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\diddm\\Desktop\\JAVA\\calendar\\src\\calendar\\schedule.txt"));
		while (true) {
			try {
				String[] fileSplit = br.readLine().split(">"); // 파일에서 날짜 분리
				dateSplit = fileSplit[0].split("-");
				if (year == Integer.parseInt(dateSplit[0]) && month == Integer.parseInt(dateSplit[1])) {
					eventDate.add(Integer.parseInt(dateSplit[2]));
				}
			} catch (NullPointerException e) {
				break;
			}
		}
		br.close();
	}

}
