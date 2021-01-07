package calendar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) throws IOException {
		int year = 0;
		int month = 0;
		int[] temp = new int[2];
		char command = 0;
		String date = "0000-0-0";
		HashMap<String, String> schedule = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		temp = CalendarItem.getTodaysCalendar(year, month);
		year = temp[0];
		month = temp[1];
		CalendarItem.printCalendar(year, month);
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
				PlanItem.cmdSearch(schedule, scanner);
				break;
			case '3':
				temp = PlanItem.cmdCal(year, month, scanner);
				year = temp[0];
				month = temp[1];
				CalendarItem.printCalendar(year, month, date);
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
