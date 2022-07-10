import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class HospitalManagement {
	static void Insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
					"MySQLPass@7612376");
			PreparedStatement stmt = con.prepareStatement("insert into hospital values(?, ?, ?, ?, ?, ?, ?, ?)");

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Staff Id ");
			int id = sc.nextInt();

			System.out.print("Enter First Name ");
			String fname = sc.next();

			System.out.print("Enter Last Name ");
			String lname = sc.next();

			System.out.print("Enter Gender\nfor male(M)\nfor female(F)\nfor other(O)\n");
			String gender = sc.next();

			System.out.print("Enter Age ");
			int age = sc.nextInt();

			System.out.print("Enter Salary ");
			int sal = sc.nextInt();

			System.out.print("Enter Role ");
			String desig = sc.next();

			System.out.print("Enter Staff Joining Year ");
			int joinYear = sc.nextInt();

			stmt.setInt(1, id);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			stmt.setString(4, gender);
			stmt.setInt(5, age);
			stmt.setInt(6, sal);
			stmt.setString(7, desig);
			stmt.setInt(8, joinYear);

			System.out.println("Data Added successfully... ");
			stmt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void Update() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
					"MySQLPass@7612376");
			PreparedStatement stmt = con.prepareStatement("Update hospital set salary= ? where id= ? ");
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Staff Id ");
			int id = sc.nextInt();

			System.out.print("Enter Staff Salary ");
			int salary = sc.nextInt();

			stmt.setInt(1, salary);
			stmt.setInt(2, id);

			stmt.execute();
			con.close();
			System.out.println("Data updated successfully...");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void Delete() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
					"MySQLPass@7612376");
			PreparedStatement stmt = con.prepareStatement("Delete from hospital where id= ?");
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Employee Id ");
			int id = sc.nextInt();

			stmt.setInt(1, id);

			System.out.println("Do you really want to delete  YES/NO");
			String ch = sc.next();
			if (ch.equalsIgnoreCase("yes")) {
				stmt.execute();
				System.out.println(" Data deleted...");
			} else {
				System.out.println("data not deleted..");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void Display() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root",
					"MySQLPass@7612376");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from hospital");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4)
						+ " : " + rs.getInt(5) + " : " + rs.getInt(6) + " : " + rs.getString(7) + " : " + rs.getInt(8));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class JDBCInJava {
	public static void main(String args[]) {
		int ch1;
		do {
			System.out.println("Welcome To Hospital Management System");
			System.out.println("1.Add the Staff");
			System.out.println("2.Update the Staff Salary");
			System.out.println("3.Delete the Staff");
			System.out.println("4.Display the Staff");
			System.out.println("5.Exit");
			System.out.println("--------------------------------");
			System.out.println("Enter your Choice ");

			Scanner sc1 = new Scanner(System.in);
			ch1 = sc1.nextInt();

			if (ch1 == 1) {
				HospitalManagement.Insert();
				break;
			}
			if (ch1 == 2) {
				HospitalManagement.Update();
				break;
			}
			if (ch1 == 3) {
				HospitalManagement.Delete();
				break;
			}
			if (ch1 == 4) {
				HospitalManagement.Display();
				break;
			}
			if (ch1 == 5) {
				System.exit(0);
				System.out.println("Thanks You ");
			}
		} while (ch1 != 5);
	}
}