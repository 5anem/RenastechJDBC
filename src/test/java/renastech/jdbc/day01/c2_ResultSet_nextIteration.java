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

        //cursor is on top of table
        //to be able to get data you need to move your cursor

        resultSet.next();//cursor is on first row which is first employee
        resultSet.next();// cursor is on second

        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

        System.out.println("employee id :" +resultSet.getString(1)   +
                " , employee first name :" +resultSet.getString(2));
        System.out.println("employee id :" +resultSet.getString("employee_id")   +
                " , employee first name :" +resultSet.getString("first_name"));


        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

        //this will continue to print from where cursor left
        while (resultSet.next()){
            System.out.println("employee id :" +resultSet.getString(1)   +
                    " , employee first name :" +resultSet.getString(2));
        }

        resultSet.close(); // will only close your result set which was query  "select * from Employees"


        //since i need to work on new query with same statment and same connection
        //we dont need to close everythin
        ResultSet resultSet2=statement.executeQuery("select * from Countries");

        //print whole table of countries

        //cursor is before table

        while (resultSet2.next()){
            System.out.println(resultSet2.getString("country_id") + " "
            +resultSet2.getString("country_name") + " "
            +resultSet2.getString("region_id"));
        }


        //
        resultSet2.close();
        statement.close();
        connection.close();




    }
}
