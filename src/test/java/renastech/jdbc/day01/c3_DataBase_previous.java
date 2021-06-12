package renastech.jdbc.day01;

import java.sql.*;

public class c3_DataBase_previous {


//    	Statement statement = connection.createStatement();
// 		//default statement will be able to only move forward in resultset
//
// 		// this will be used to created ResultSet that can move freely
// 		Statement statement= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );

    public static void main(String[] args) throws SQLException {
        //conn-state-resultset

        //connection
        //url.,username,password

        String url="jdbc:oracle:thin:@54.88.118.39:1521:XE";
        String userName="hr";
        String password="hr";

        Connection connection= DriverManager.getConnection(url,userName,password);

        //statment
        //you need to create statement from connection
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //this statement will give me abilty to move anywhere in table

        ResultSet resultSet=statement.executeQuery("SELECT * FROM locations WHERE country_ID = 'US'");

        //move cursor
        resultSet.next(); // row 1
        System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));

        resultSet.next(); // row 2
        resultSet.next(); // row 3
        resultSet.next(); // row 4
        //resultSet.next(); //row 5  //Result set after last row
        //System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city")); //Result set after last row


        //move back
        resultSet.previous(); // row 3
        System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));


        resultSet.previous(); // row 2
        resultSet.previous(); // row 1
        //resultSet.previous(); // row 0
        //System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));

        //this will move the cursor to last location we have
        resultSet.last();//1700 Seattle
        System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));

        //this will move the cursor to first data
        resultSet.first();//1400 Southlake
        System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));


        //to move cursor to before first row whihc is  top of table
        resultSet.beforeFirst();
        //System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));

        //this will move cursor after last data
        resultSet.afterLast();
        //System.out.println(resultSet.getString(1)  +" " + resultSet.getString("city"));

        while (resultSet.previous()){
            System.out.println(resultSet.getString("location_id") + " "
                    + resultSet.getString("state_province") + " " +
                    resultSet.getString("country_id"));
        }


        ///clean your connection
        //close
        resultSet.close();
        statement.close();
        connection.close();
    }
}
