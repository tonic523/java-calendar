package calendar;

import java.util.Scanner;

public class Prompt {

	public final static String PROMPT = "cal> ";
	
	public static void main(String[] args) {	
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);
		System.out.println("연도를 입력하세요.");
		System.out.printf(PROMPT);
		int year = scanner.nextInt();		
		while(true) {
			System.out.println("월을 입력하세요.(종료 = -1)");
			System.out.printf(PROMPT);
			int month = scanner.nextInt();
			
			if(month == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if (month < 1 | month > 12) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요!");
				continue;
			}
			
			cal.printCalendar(year, month);
			
		}
		scanner.close();
	}

}
