package calendar;

public class Calendar {

	public static int[] MONTH_OF_MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Calendar() {

	}

	public static int getLeapdays(int year) {
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
		return february;
	}
	
	public static int getWeekday(int year, int month) {
		year --;
		int week = 1;
		week = 1 + ((year + year/4 - year/100 + year/400) % 7);
		if (month != 1) {
			for (int i = 0; i < month - 1; i++) {
				week = (week + (Calendar.MONTH_OF_MAX_DAYS[i] % 7)) % 7;
			}
		}
		return week;
	}
	
	public static void printCalendar(int year, int month) {	
		MONTH_OF_MAX_DAYS[1] = getLeapdays(year); // 윤년 계산
		int week = getWeekday(year, month); // 1일 요일 계산
		System.out.printf("     <<%4d %2d>>", year, month);
		System.out.println();
		System.out.println("SU\tMO\tTU\tWE\tTH\tFR\tSA");
		System.out.println(" -------------------------------------------------");
		for (int i = 0; i < week; i++) {
			System.out.printf("  \t");
		}
		for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
			System.out.printf(i + "\t");
			if ((i + week) % 7 == 0) {
				System.out.println();
			}

		}

	}

}
