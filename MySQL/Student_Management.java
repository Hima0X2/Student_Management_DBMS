package MySQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Student_Management {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Welcome to studemt management app");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student");
			System.out.println("Press 3 to DISPLAY student");
			System.out.println("Press 4 to Exit App");
			Scanner sc = new Scanner(System.in);
			int a = Integer.parseInt(br.readLine());
			if (a == 1) {
				System.out.println("Enter ID : ");
				int id =Integer.parseInt(br.readLine());
				System.out.println("Enter Name : ");
				String name = br.readLine();
				System.out.println("Enter Roll : ");
				int roll =Integer.parseInt(br.readLine());
				System.out.println("Enter GPA : ");
				double gpa = Double.parseDouble(br.readLine());
				System.out.println("Enter Number : ");
				int number = Integer.parseInt(br.readLine());
				Student s = new Student(id, roll, name, number, gpa);
				if (Database.insertStudenttoDB(s)) {
					System.out.println("Data add successfully.");
				} else {
					System.out.println("Something Went wrong.Please try again....");
				}
			} else if (a == 2) {
				System.out.println("Enter Student ID to delete : ");
				int id=Integer.parseInt(br.readLine());
				if (Database.deleteStudenttoDB(id)) {
					System.out.println("Data Delete successfully.");
				} else {
					System.out.println("Something Went wrong.Please try again....");
				}
			} else if (a == 3) {
				Database.showAll();
			} else if (a == 4) {
				break;
			} else {
				System.out.println("Invalid Press.Press right one.");
			}
		}
	}

}
