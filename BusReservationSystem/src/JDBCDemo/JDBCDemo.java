package JDBCDemo;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        update();
        readRecords();

    }

    //Read
    public static void readRecords() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";
        String query = "select * from employee;";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt(1));
            System.out.println("Employee name: " + rs.getString(2));
            System.out.println("Employee salary: " + rs.getInt(3));
        }

        con.close();
    }

    //Create
    public static void insertRecords() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";
        String query = "insert into employee values (4,'Mahil', 50000)";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("Rows affected: " + rows);

        con.close();
    }

    public static void insertVar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";

        int id = 5;
        String employeeName = "Mommom";
        int salary = 50000;
        //(5,"Mommom", 50000)
        String query = "insert into employee values (" + id + ",'" + employeeName + "'," + salary + ");";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("Rows affected: " + rows);

        con.close();
    }


    public static void insertUsingPst() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";

        int id = 6;
        String employeeName = "Mommom";
        int salary = 150000;
        //(5,"Mommom", 50000)
        String query = "insert into employee values (?,?,?);";
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        pst.setString(2, employeeName);
        pst.setInt(3, salary);
        int rows = pst.executeUpdate();
        System.out.println("Rows affected: " + rows);
        con.close();
    }

    //delete
    public static void delete() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";

        int id = 2;
        String query = "delete from employee where emp_id = " + id;
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);
        System.out.println("Row deleted: " + rows);
        con.close();
    }

    //Update
    public static void update() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "*Mareen7#";

        String query = "update employee set salary = 2000000 where emp_id=1";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);
        System.out.println("Row updated: " + rows);
        con.close();
    }

}


