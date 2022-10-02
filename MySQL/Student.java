package MySQL;

public class Student {
	private int studentId;
	private String studentName;
	private int studentRoll;
	private double studentGPA;
	private int studentNumber;
	Student(int id,int roll,String studentName,int number,double gpa){
		this.studentId=id;
		this.studentGPA=gpa;
		this.studentName=studentName;
		this.studentNumber=number;
		this.studentRoll=roll;
	}
	Student(int studentRoll,String studentName,int studentNumber,double studentGPA){
		this.studentGPA=studentGPA;
		this.studentName=studentName;
		this.studentNumber=studentNumber;
		this.studentRoll=studentRoll;
	}
	Student(){
		super();
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}
	public double getStudentGPA() {
		return studentGPA;
	}
	public void setStudentGPA(double studentGPA) {
		this.studentGPA = studentGPA;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRoll=" + studentRoll
				+ ", studentGPA=" + studentGPA + ", studentNumber=" + studentNumber + "]";
	}
}
