package calendar;

public class Calendar {

	public static int[] MONTH_OF_MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Calendar() {

	}

	public void printCalendar(int year, int month, int week) {
		// 윤년 구하기
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

		// 달력 출력
		System.out.printf("     <<%4d %2d>>", year, month);
		System.out.println();
		System.out.println("SU\tMO\tTU\tWE\tTH\tFR\tSA");
		System.out.println(" -------------------------------------------------");
		for (int i = 0; i < week; i++) {
			System.out.printf("\t");
		}
		for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
			System.out.printf(i + "\t");
			if ((i + week) % 7 == 0) {
				System.out.println();
			}

		}

	}

}
