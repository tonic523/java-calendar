package calendar;

public class Calendar {

	public final static int[] MONTH_OF_MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Calendar() {
		
	}
	public void printCalendar(int year, int month) {
		System.out.printf("     <<%4d %2d>>", year, month);
		System.out.println();
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" ---------------------");
		for (int i = 1; i <= MONTH_OF_MAX_DAYS[month - 1]; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
}


}
