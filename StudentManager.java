package Assignment_9;

import java.sql.*;
import java.util.Scanner;

public class StudentManager 
{
    //Adds a new student to DB
    public void addStudent(Scanner sc) throws Exception 
{
        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter DoB(YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();
        sc.nextLine();

        if(prn.isEmpty() || name.isEmpty() || marks < 0 || marks > 100){
            throw new InvalidDataException("Invalid student data provided.");
        }

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO students VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, prn);
        ps.setString(2, name);
        ps.setString(3, dob);
        ps.setFloat(4, marks);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Student added successfully." : "Insert failed.");

        con.close();
    }

    //Displays all students
    public void displayStudents() throws Exception{
        Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        System.out.println("PRN\tName\tDoB\tMarks");
        while(rs.next())
        {
            System.out.println(rs.getString(1) + "\t" +
                               rs.getString(2) + "\t" +
                               rs.getString(3) + "\t" +
                               rs.getFloat(4));
        }

        con.close();
    }

    //Search student by PRN
    public void searchByPRN(Scanner sc) throws Exception
    {
        System.out.print("Enter PRN to search: ");
        String prn = sc.nextLine();

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM students WHERE prn = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prn);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            System.out.println("Found: " + rs.getString(2) + ", " + rs.getString(3) + ", Marks: " + rs.getFloat(4));
        } 
        
        else{
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        }

        con.close();
    }

    //Update student record
    public void updateStudent(Scanner sc) throws Exception
    {
        System.out.print("Enter PRN of student to update: ");
        String prn = sc.nextLine();

        Connection con = DBConnection.getConnection();
        
        String checkSql = "SELECT * FROM students WHERE prn = ?";
        PreparedStatement check = con.prepareStatement(checkSql);
        check.setString(1, prn);
        ResultSet rs = check.executeQuery();

        if(!rs.next()){
            con.close();
            throw new StudentNotFoundException("Student not found for update.");
        }

        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new DoB: ");
        String dob = sc.nextLine();

        System.out.print("Enter new Marks: ");
        float marks = sc.nextFloat();
        sc.nextLine();

        if(name.isEmpty() || marks < 0 || marks > 100){
            throw new InvalidDataException("Invalid updated data.");
        }

        String updateSql = "UPDATE students SET name=?, dob=?, marks=? WHERE prn=?";
        PreparedStatement ps = con.prepareStatement(updateSql);

        ps.setString(1, name);
        ps.setString(2, dob);
        ps.setFloat(3, marks);
        ps.setString(4, prn);
        ps.executeUpdate();

        System.out.println("Student updated successfully.");
        con.close();
    }

    //Delete student record
    public void deleteStudent(Scanner sc) throws Exception
    {
        System.out.print("Enter PRN to delete: ");
        String prn = sc.nextLine();

        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE prn=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prn);

        int rows = ps.executeUpdate();
        if(rows == 0){
            throw new StudentNotFoundException("Student not found for deletion.");
        } 
        
        else{
            System.out.println("Student deleted successfully.");
        }

        con.close();
    }
}
