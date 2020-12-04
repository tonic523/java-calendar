package calendar;

import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {	

		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);	
		while(true) {
			//연도 입력
			System.out.println("연도를 입력하세요.");
			System.out.printf("YEAR> ");
			int year = scanner.nextInt();
			
			//월 입력
			System.out.println("월을 입력하세요.(종료 = -1)");
			System.out.printf("MONTH> ");
			int month = scanner.nextInt();
			
			//예외 처리
			if(month == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if (month < 1 | month > 12) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요!");
				continue;
			}
			
			//달력 출력
			cal.printCalendar(year, month);
			
		}
		scanner.close();
	}

}
