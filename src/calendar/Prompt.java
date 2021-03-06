package calendar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) throws IOException {
		int year = 0;
		int month = 0;
		int[] yearMonth = new int[2];
		ArrayList<Integer> eventDate = new ArrayList<>();
		char command = 0;
		Scanner scanner = new Scanner(System.in);
		// 오늘 날짜 월 연도 계산
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		//
		CalendarItem.printCalendar(year, month, eventDate);
		PlanItem.cmdMenu();
		boolean b = true;
		while (b) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");
			command = scanner.next().charAt(0);
			scanner.nextLine(); // 개행문자 제거
			switch (command) {
			case '1':
				PlanItem.cmdRegister(scanner);
				break;
			case '2':
				PlanItem.cmdSearch(scanner);
				break;
			case '3':
				yearMonth = PlanItem.cmdCal(year, month, scanner);
				year = yearMonth[0];
				month = yearMonth[1];
				CalendarItem.printCalendar(year, month, eventDate);
				break;
			case 'h':
				PlanItem.cmdMenu();
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

}
