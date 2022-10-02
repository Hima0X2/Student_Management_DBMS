package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	public static boolean insertStudenttoDB(Student student) {
		try {
			Connection c=Connection_creator.create();
			PreparedStatement p=c.prepareStatement("insert into student(id,name,roll,gpa,number) values(?,?,?,?,?)");//for dynamic queries
			//set value
			p.setInt(1, student.getStudentId());
			p.setString(2, student.getStudentName());
			p.setInt(3, student.getStudentRoll());
			p.setDouble(4, student.getStudentGPA());
			p.setInt(5, student.getStudentNumber());
			//System.out.println(p);
			p.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public static boolean deleteStudenttoDB(int id) {
		try {
			Connection c=Connection_creator.create();
			PreparedStatement p=c.prepareStatement("delete from student where id=?");//for dynamic queries
			//set value
			p.setInt(1,id);
			p.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static boolean update(Student s) {
		try {
			Connection c=Connection_creator.create();
			PreparedStatement p=c.prepareStatement("update student set roll=? ,name= ? ,gpa =? ,number = ? where id= ?");//for dynamic queries
			//set value
			p.setInt(1, s.getStudentRoll());
			p.setString(2, s.getStudentName());
			p.setDouble(3, s.getStudentGPA());
			p.setInt(4, s.getStudentNumber());
			p.setInt(5, s.getStudentId());
			//System.out.println(p);
			p.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static void showAll() {
		try {
			Connection c=Connection_creator.create();
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next()) {
		        String id= rs.getString(1);
		        String name= rs.getString(2);
		        String roll= rs.getString(3);
		        String gpa= rs.getString(4);
		        String number= rs.getString(5);
		        System.out.println("Id : "+id+"\nName : "+name+"\nRoll : "+roll+"\nGPA : "+gpa+"\nNumber : "+number);
		        System.out.println("---------------");
		      }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void Import() {
		try {
			Connection c=Connection_creator.create();
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next()) {
				GUI.rows[0]=rs.getString(1);
				GUI.rows[1] = rs.getString(2);
				GUI.rows[2] = rs.getString(3);
				GUI.rows[3] = rs.getString(4);
				GUI.rows[4] = rs.getString(5);
		        GUI.model.addRow(GUI.rows);
		      }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
