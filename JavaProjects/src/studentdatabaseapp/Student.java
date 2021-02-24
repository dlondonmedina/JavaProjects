package studentdatabaseapp;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private int[] courses;
	private int index = 0;
	private int tuitionBalance = 0;
	private static int courseLimit = 4;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// constructor takes name and year
	public Student(String firstName, String lastName, int gradeLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeLevel;
		this.courses = new int[Student.courseLimit];
		setStudentId();
	}
	// Generate id
	private void setStudentId() {
		id++;
		this.studentID = this.gradeYear + "" + id;
	}
	
	public int getBalance() {
		return this.tuitionBalance;
	}
	
	public String getStudentID() {
		return this.studentID;
	}
	
	public boolean enroll(int course) {
		if (this.index < Student.courseLimit) {
			this.courses[this.index] = course;
			this.index++;
			this.tuitionBalance = this.tuitionBalance + Student.costOfCourse;
			return true;
		}	
		return false;
	}
	
	public int payTuition(int amount) {
		if (this.tuitionBalance > 0) {
			this.tuitionBalance = this.tuitionBalance - amount;
			return this.getBalance();
		}
		return 0;
	}
	
	// show status
	public String getStudent() {
		String cs = "";
		for (int i = 0; i < this.courses.length; i++) {
			switch(this.courses[i]) {
				case 1:
					cs = cs + "History 101\n";
					break;
				case 2:
					cs = cs + "Mathematics 101\n";
					break;
				case 3:
					cs = cs + "English 101\n";
					break;
				case 4:
					cs = cs + "Chemistry 101\n";
					break;
				case 5:
					cs = cs + "Computer Science 101\n";
					break;
				default:
					break;
		
			}
		}
		String out = "Student: " + 
					this.studentID + "\nName: " + 
					this.firstName + " " + 
					this.lastName + "\nGrade Level: " + 
					this.gradeYear + "\n\n" + "Courses: " + 
					cs + "\n\n" +
					"Balance: $" + this.tuitionBalance;
		return out;
	}
}
