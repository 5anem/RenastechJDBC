package renastech.jdbc.day01;

import java.sql.*;

public class c2_ResultSet_nextIteration {

    public static void main(String[] args) throws SQLException {


        //each time i will need connection- statemnet -resultset

        //connection
        //url.,username,password

        String url="jdbc:oracle:thin:@54.88.118.39:1521:XE";
        String userName="hr";
        String password="hr";

        Connection connection=DriverManager.getConnection(url,userName,password);

        //statment
        //you need to create statement from connection
        Statement statement=connection.createStatement();

        //run query
        //resultset
        ResultSet resultSet=statement.executeQuery("select * from Employees");

        //print  second employee id and name from employees table

    }
}
