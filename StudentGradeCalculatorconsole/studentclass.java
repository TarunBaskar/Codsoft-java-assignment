package StudentGradeCalculatorconsole;


import java.util.*;


public class studentclass {
	private static final String studentTotal = null;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		//student name from user
		System.out.print("Enter the Student Name:");
		String studName = sc.nextLine();
		
		//register number from user
		System.out.print("Enter the register no of the Student:");
		String studRegno = sc.nextLine();
		
		//subjects
		String subject[] = {"English","Maths","Physics","Chemistry","Biology","Computer Science"};
		System.out.println("----------------STUDENT GRADE CALCULATOR-----------------");
		
		//marks
		int marks[] = new int[subject.length];
		for(int i=0;i<subject.length;i++) {
			System.out.println("Enter the Mark for "+subject[i]+" (out of 100) : ");
			int mark = sc.nextInt();
			if(mark<0 || mark>100) {
				System.out.println("The subject mark is not in range.... .Please enter the correct mark");
				i--;
			}else {
				marks[i] = mark;
			}
		}
		
		//get the total mark
		int studentTotal = calculateStudentTotal(marks);
		
		//get the average mark
		double studentAverage = calculateStudentAverage(studentTotal,subject.length);
		
		//get the grade of the student
		char studentGrade = calculateStudentGrade(studentAverage);
		
		if(studentGrade == 'F') {
			System.out.println("Sorry, "+studName+" you have Failed");
			displayDetails(subject,marks,studentTotal,studentAverage);
		}else {
			System.out.println("Congratulations, "+studName+" you have passed with Grade "+ studentGrade);
			displayDetails(subject,marks,studentTotal,studentAverage);
		}
		
	}
	
	private static int calculateStudentTotal(int marks[]) {
		int sum = 0;
		for(int i=0;i<marks.length;i++) {
			sum += marks[i];
		}
		return sum;
	}
	
	private static double calculateStudentAverage(int total,int length) {
		return (double)total/length;
	}
	
	private static char calculateStudentGrade(double average) {
		if(average >=95) {
			return 'O';
		}
		else if(average >= 90) {
			return 'A';
		}
		else if(average >= 80) {
			return 'B';
		}
		else if(average >= 70) {
			return 'C';
		}
		else if(average >= 60) {
			return 'D';
		}
		else if(average >= 50) {
			return 'E';
		}
		else {
			return 'F';
		}
	}
	
	private static void displayDetails(String subject[],int marks[], int total,double average) {
		 System.out.println("Subject		Marks");
		 for(int i=0;i<subject.length;i++) {
			 System.out.println(subject[i]+"		"+marks[i]);
		 }
		 System.out.println("The Total Mark of all Subject is "+total);
		 System.out.println("The Average Mark of the all Subject is "+average+"%");
		 
		 System.out.println("----------------Thank You------------------");
	}
}
