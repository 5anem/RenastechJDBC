package renastech.jdbc.day01_part2;

import renastech.jdbc.utils.DataBaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class c1_ResultSetMetaData {

    public static void main(String[] args) throws SQLException {

        //create utils package
//create DataBaseUtil class
//create method called connectionDatabase under DataBaseUtil
//this method will take connection url , username and password
//it will create connection

//so we dont need to type below lines each time in the class
//    String url="jdbc:oracle:thin:@54.88.118.39:1521:XE";
//    String userName="hr";
//    String password="hr";
//
//    Connection connection= DriverManager.getConnection(url,userName,password);

        DataBaseUtil.connectionDatabase();

//        //statment
//        //you need to create statement from connection
//        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        //this statement will give me abilty to move anywhere in table
//
//        ResultSet resultSet=statement.executeQuery("SELECT * FROM Regions");

        ResultSet resultSet=DataBaseUtil.runQuery("select * from employees");

        resultSet.next();

        System.out.println(resultSet.getString(3));



    }

}
