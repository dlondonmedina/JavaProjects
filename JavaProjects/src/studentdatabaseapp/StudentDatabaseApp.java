package studentdatabaseapp;

import java.util.HashMap;
import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many students to enter: ");
		int count = in.nextInt();
		
		HashMap<String, Student> students = new HashMap<String, Student>();
		
		for (int i = 0; i < count; i++) {
			System.out.println("Enter student first name: ");
			String firstName = in.next();
			System.out.println("Enter student last name: ");
			String lastName = in.next();
			System.out.println("Enter student grade level:\n  1 - Freshman\n  2 - Sophmore\n  3 - Junior\n  4 - Senior\n");
			int gradeLevel = in.nextInt();
			Student stu = new Student(firstName, lastName, gradeLevel);
			boolean more = true;
			while (more) {
				System.out.println("Entroll in a course:\n 1 - History\n 2 - Mathematics\n 3 - English\n 4 - Chemistry\n 5 - Computer Science \nor type 0 to finish. ");
				int course = in.nextInt();
				if (course < 6 && course > 0 ) { more = stu.enroll(course); }
				else { more = false; }
			}
			System.out.print(stu.getStudent() + "\n\n\n");
			students.put(stu.getStudentID(), stu);
		}
	
		
		// View Balance
		System.out.println("Enter a Student ID to see their information: ");
		String s = in.next();
		Student student = students.get(s);
		
		System.out.println("The balance is: " + student.getStudent());
		
		System.out.println("Enter a StudentID to pay tuition: ");
		s = in.next();
		System.out.println("Their balance is: " + student.getBalance());
		System.out.println("Do you want to pay now? (Y/n) ");
		if (in.next().toLowerCase() != "n") {
			System.out.println("How much would you like to pay? ");
			int payment = in.nextInt();
			
			int balance = student.payTuition(payment);
			if (balance >= 0) {
				System.out.println("Thank you for your payment! \nYour balance is: $" + balance);
			} else {
				System.out.println("Thank you for your payment! \nYou get $" + (balance * -1) + " back as change!");
			}
		}
		
		in.close();

	}

}
