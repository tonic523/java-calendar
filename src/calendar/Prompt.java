package calendar;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Calendar;

public class Prompt {

	public static void main(String[] args) {
		int year = 0;
		int month = 0;
		int[] temp = new int[2];
		char command = 0;
		String date = "0000-0-0";
		HashMap<String, String> schedule = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		temp = getTodaysCalendar(year,month);
		year = temp[0];
		month = temp[1];
		Calendar2.printCalendar(year, month);
		cmdMenu();
		boolean b = true;
		while (b) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");
			command = scanner.next().charAt(0);
			scanner.nextLine(); // 개행문자 제거
			switch (command) {
			case '1':
				System.out.println("[일정 등록] 날짜를 입력하세요.(yyyy.mm.dd)");
				System.out.print("> ");
				date = scanner.nextLine();
				System.out.println("일정을 입력하세요.");
				String dateSchedule = scanner.nextLine();
				schedule.put(date, dateSchedule);
				System.out.println("일정이 등록되었습니다.");
				break;
			case '2':
				cmdSearch(schedule, scanner);
				break;
			case '3':			
				temp = cmdCal(year, month, scanner);
				year = temp[0];
				month = temp[1];
				Calendar2.printCalendar(year, month, date);
				break;
			case 'h':
				cmdMenu();
				break;
			case 'q':
				b = false;
				System.out.println("bye");
				break;
			default:
				break;
			}
		}
		scanner.close();
	}

	private static int[] getTodaysCalendar(int year, int month) {
		int[] ym = new int[2];
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		ym[0] = year;
		month = cal.get(Calendar.MONTH) + 1;
		ym[1] = month;
		return ym;
		
	}

	private static void cmdMenu() {
		System.out.println("+--------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 딜력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+--------------+");

	}

	private static void cmdSearch(HashMap<String, String> schedule, Scanner s) {
		System.out.println("[일정 검색] 날짜를 입력하세요.(yyyy.mm.dd)");
		System.out.print("> ");
		String date = s.nextLine();
		System.out.printf("%s\n", schedule.get(date));
	}

	private static int[] cmdCal(int year, int month, Scanner s) {
		int[] ym = new int[2];
		System.out.println("연도를 입력하세요.");
		System.out.printf("YEAR> ");
		year = s.nextInt();
		ym[0] = year;
		System.out.println("월을 입력하세요.(종료 = -1)");
		System.out.printf("MONTH> ");
		month = s.nextInt();
		ym[1] = month;
		return ym;	
	}

}
