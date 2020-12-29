package calendar;

import java.util.Scanner;

public class Prompt {
	
	public static void main(String[] args) {
		int year = 2020;
		int month = 1;
		int week = 1;
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			// 연도 입력
			System.out.println("연도를 입력하세요.");
			System.out.printf("YEAR> ");
			year = scanner.nextInt();

			// 월 입력
			System.out.println("월을 입력하세요.(종료 = -1)");
			System.out.printf("MONTH> ");
			month = scanner.nextInt();
			
			// 예외 처리
			if (month == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (month < 1 | month > 12) {
				System.out.println("월을 잘못 입력하였습니다. 다시 입력해주세요!");
				continue;
			}
			// Get leapdays
			Calendar.MONTH_OF_MAX_DAYS[1] = cal.getLeapdays(year);
			
			// 년, 월의 1일 요일 계산
			week = cal.getWeekday(year, month);
			
			// 달력 출력
			cal.printCalendar(year, month, week);
			System.out.println("");
		}
		scanner.close();

	}

}
