package calendar;

import java.util.Calendar;

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

	public static void calendarOutline(int year, int month) {
		System.out.printf("     <<%4d %2d>>", year, month);
		System.out.println();
		System.out.println("SU\tMO\tTU\tWE\tTH\tFR\tSA");
		System.out.println(" -------------------------------------------------");
	}

	public static void printCalendar(int year, int month) {
		getLeapdays(year); // 윤년 계산
		int week = getWeekday(year, month); // 1일 요일 계산
		calendarOutline(year, month);
		for (int i = 0; i < week; i++) {
			System.out.printf("  \t");
		}
		for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
			System.out.printf(i + "\t");
			if ((i + week) % 7 == 0) {
				System.out.println();
			}

		}
		System.out.println();
	}
//파일에 저장된 날짜 불러오기
	public static void printCalendar(int year, int month, String date) {
		calendarOutline(year, month);
		getLeapdays(year); // 윤년 계산
		int week = getWeekday(year, month); // 1일 요일 계산
		String[] dateSplit = date.split("-");
		for (int i = 0; i < week; i++) {
			System.out.printf("  \t");
		}
		if (year == Integer.parseInt(dateSplit[0]) && month == Integer.parseInt(dateSplit[1])) {
			for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
				if (i == Integer.parseInt(dateSplit[2])) {
					System.out.printf(".");
				}
				System.out.printf(i + "\t");
				if ((i + week) % 7 == 0) {
					System.out.println();
				}
			}
		} else {
			for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
				System.out.printf(i + "\t");
				if ((i + week) % 7 == 0) {
					System.out.println();
				}

			}
		}
		System.out.println();
	}

}
