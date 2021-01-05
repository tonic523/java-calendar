package calendar;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Calendar;

public class Prompt {

	static void ui() {
		System.out.println("+--------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 딜력 보기");
		System.out.println("| 4. 도움말 q. 종료");
		System.out.println("+--------------+");

	}

	static void scheduleRegistration() {

	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int command = 0;
		String date;
		String dateSchedule;
		HashMap<String, String> schedule = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		Calendar2.printCalendar(year, month);
		ui();
		while (true) {
			System.out.println("명령 (1, 2, 3, 4, 5)");
			System.out.print("> ");
			command = scanner.nextInt();
			scanner.nextLine(); // 개행문자 제거
			switch (command) {
			case 1:	
				System.out.println("[일정 등록] 날짜를 입력하세요.");
				System.out.print("> ");
				date = scanner.nextLine();
				System.out.println("일정을 입력하세요.");
				dateSchedule = scanner.nextLine();
				schedule.put(date, dateSchedule);
				System.out.println("일정이 등록되었습니다.");
				break;
			case 2:
				System.out.println("[일정 검색] 날짜를 입력하세요.");
				System.out.print("> ");
				date = scanner.nextLine();
				System.out.printf("%d개의 일정이 있습니다.\n", schedule.size());
				for (int i = 0; i < schedule.size(); i++) {
					System.out.printf("%d. %s\n", i+1, schedule.get(date));
				}
				break;
			case 3:
				System.out.println("연도를 입력하세요.");
				System.out.printf("YEAR> ");
				year = scanner.nextInt();
				System.out.println("월을 입력하세요.(종료 = -1)");
				System.out.printf("MONTH> ");
				month = scanner.nextInt();
				Calendar2.printCalendar(year, month);
				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}
		}
	}
}
