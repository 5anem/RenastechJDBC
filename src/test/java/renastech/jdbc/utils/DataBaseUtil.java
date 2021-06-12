package renastech.jdbc.utils;

import javax.xml.transform.Result;
import java.sql.*;

public class DataBaseUtil {


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    //this method will do connection with oracle database
    public static void connectionDatabase(){
        String url=ConfigurationReader.getProperty("oracle.databese.url");
        String userName=ConfigurationReader.getProperty("oracle.databese.username");
        String password=ConfigurationReader.getProperty("oracle.databese.password");
//
        try {
            connection= DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection Failed !!!!!!!!!!!" );
        }

    }


}
