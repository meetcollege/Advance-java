package crud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class Crud {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Connection credentials
        String url = "jdbc:mysql://localhost:3309/firstp";
        String user = "root";
        String password = "";

        try {
            // Driver loading
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            System.out.println("Database is connected");

            // Switch case for different operations
            while (true) {
                System.out.println("\n1. Insert\n2. Update\n3. Delete\n4. Retrieve\n5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                String query = null;
                int id = 0;
                String name = null;
                String department = null;

                switch (ch) {
                    case 1:
                        // Insert Operation
                        System.out.print("Enter emp id: ");
                        id = sc.nextInt();
                        System.out.print("Enter emp name: ");
                        name = sc.next();
                        System.out.print("Enter emp department: ");
                        department = sc.next();

                        query = "INSERT INTO emp (id, name, dept) VALUES (" + id + ", '" + name + "', '" + department + "')";
                        int rowsInserted = st.executeUpdate(query);
                        if (rowsInserted > 0) {
                            System.out.println("Employee inserted successfully.");
                        }
                        break;

                    case 2:
                        // Update Operation
                        System.out.print("Enter emp id to update: ");
                        id = sc.nextInt();
                        System.out.print("Enter new emp name: ");
                        name = sc.next();
                        System.out.print("Enter new emp department: ");
                        department = sc.next();

                        query = "UPDATE emp SET name = '" + name + "', dept = '" + department + "' WHERE id = " + id;
                        int rowsUpdated = st.executeUpdate(query);
                        if (rowsUpdated > 0) {
                            System.out.println("Employee updated successfully.");
                        } else {
                            System.out.println("Employee with id " + id + " not found.");
                        }
                        break;

                    case 3:
                        // Delete Operation
                        System.out.print("Enter emp id to delete: ");
                        id = sc.nextInt();

                        query = "DELETE FROM emp WHERE id = " + id;
                        int rowsDeleted = st.executeUpdate(query);
                        if (rowsDeleted > 0) {
                            System.out.println("Employee deleted successfully.");
                        } else {
                            System.out.println("Employee with id " + id + " not found.");
                        }
                        break;

                    case 4:
                        // Retrieve Operation
                        System.out.println("Employee List:");
                        query = "SELECT * FROM emp";
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: " + rs.getString("dept"));
                        }
                        break;

                    case 5:
                        System.out.println("Exiting program.");
                        conn.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
