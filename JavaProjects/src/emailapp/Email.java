package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int passwordLengthDefault = 10;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName + " " + this.department);
		this.password = this.randomPassword(this.passwordLengthDefault);
		System.out.println("Your password: " + this.password);
		
		// Generate email
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
		System.out.println("Your email: " + this.email);
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
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#@!$%";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}

	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return this.mailboxCapacity; }
	public String getAlternateEmail() { return this.alternateEmail; }
	public String getPassword() { return this.password; }
	
}
