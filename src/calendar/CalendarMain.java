package calendar;

import java.util.Scanner;

public class CalendarMain {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void getMaxDaysOfMonth(int month) {
		System.out.printf("%d월은 %d일까지 있습니다.\n", month, MAX_DAYS[month - 1]);
	}

	public void printSampleCalender() {
		System.out.println("  일   월    화    수    목    금    토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();
		CalendarMain cal = new CalendarMain();

		if (month < 1 | month > 12) {
			System.out.println("잘못 입력하였습니다.");
		} else {
			cal.getMaxDaysOfMonth(month);
		}
		cal.printSampleCalender();
		scanner.close();

	}

}
