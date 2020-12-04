package calendar;

import java.util.Scanner;

public class Prompt {
	/**요일 계산기
	 * 		
	 * @param week
	 * @return (0,sunday) , (6,saturday)
	 */
	public static int parseDay(String week) {
		if (week.equals("su"))
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return 0;

	}

	public static void main(String[] args) {
		int year = 2020;
		int month = 1;
		int week = 0;

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

			// 시작하는 요일 입력
			System.out.println("첫번째 요일을 입력하세요. (su mo tu we th fr sa)");
			System.out.printf("WEEKDAY> ");
			String weekday = scanner.next();
			week = parseDay(weekday);
			
			// 예외 처리
			if (month == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (month < 1 | month > 12) {
				System.out.println("월을 잘못 입력하였습니다. 다시 입력해주세요!");
				continue;
			}

			// 달력 출력
			cal.printCalendar(year, month, week);
			System.out.println("");
		}
		scanner.close();

	}

}
