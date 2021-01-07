package calendar;

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class PlanItem {
	public static void cmdMenu() {
		System.out.println("+--------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 딜력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+--------------+");

	}

	public static void cmdSearch(HashMap<String, String> schedule, Scanner s) {
		System.out.println("[일정 검색] 날짜를 입력하세요.(yyyy.mm.dd)");
		System.out.print("> ");
		String date = s.nextLine();
		//파일에서 일정 불러오기
		System.out.printf("%s\n", schedule.get(date));
	}

	public static int[] cmdCal(int year, int month, Scanner s) {
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

	public static void cmdRegister(Scanner s) throws IOException {
		PrintWriter scheduleFile = new PrintWriter(new FileWriter("C:\\Users\\diddm\\Desktop\\JAVA\\calendar\\src\\calendar\\schedule.txt", true));
		System.out.println("[일정 등록] 날짜를 입력하세요.(yyyy-mm-dd)");
		System.out.print("> ");
		String date = s.nextLine();
		System.out.println("일정을 입력하세요.");
		String dateSchedule = s.nextLine();
		scheduleFile.write(date);
		scheduleFile.write(">");
		scheduleFile.println(dateSchedule);		
		System.out.println("일정이 등록되었습니다.");
		scheduleFile.close();
	}
}
