package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity;
	private String alternateEmail;
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName + " " + this.department);
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("Enter the Department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		in.close();
		if (deptChoice == 1) { return "sales"; }
		else if (deptChoice == 2) { return "dev";}
		else if (deptChoice == 3) { return "acct";}
		else { return ""; }
	
	}
	// Generate random password
	
	// Set the mailbox capacity
	
	// Set the alternate email
	
	// Change the password
}
