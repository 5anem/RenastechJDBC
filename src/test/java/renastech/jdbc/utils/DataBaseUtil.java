package renastech.jdbc.utils;

import javax.xml.transform.Result;
import java.sql.*;

public class DataBaseUtil {


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    //this method will do connection with oracle database
    public static void connectionDatabase(){
        String url=ConfigurationReader.getProperty("oracle.database.url");
        String userName=ConfigurationReader.getProperty("oracle.database.username");
        String password=ConfigurationReader.getProperty("oracle.database.password");
//
        try {
            connection= DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection Failed !!!!!!!!!!!" );
        }

    }


    //this method will run query
    //we need statement and resultset


    public static ResultSet runQuery(String query){

        try {
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Query Failed");
        }

        return resultSet;
    }


    //create a utils that will print me total number of column
    //return type should be int
    //name of method getTotalColumnCount

    //ResultSetMetaData
    //getColumnCount

    // ResultSetMetaData rmsd=resultSet.getMetaData();
    //        //we will be able to use librarry from metadata
    //
    //        //such as column name column count
    //        int columnCount=rmsd.getColumnCount();
    //        System.out.println("columnCount = " + columnCount);

    public static int getTotalColumnCount(){

        int columnCount=0;
        try {
            ResultSetMetaData rmsd=resultSet.getMetaData();
            columnCount=rmsd.getColumnCount();
        } catch (SQLException throwables) {
            System.out.println("Errror while counting column counts");
            throwables.printStackTrace();
        }

        return columnCount;

    }

    //Task3
    // //create a utils that will print me all data from table feel free to use your imagination on this.
    //    //return type should be void
    //    //name of method getAllData
    //      to be able to print all data you would need to print each column for each row  :
    //      1.you need to know totalcolumncount
    //      2.Also you will need to have loop where you can move between columns and rows.
    //
    //   hint: check example that we did on c2_practice on saturday you will get more idea

    public static void getAllData(){
        int totalColumnCount=DataBaseUtil.getTotalColumnCount();

        try {
            //anytime i call this method to be able to print everything
            // from  first row to last row
            // i need to make sure my cursor is on first row

            resultSet.beforeFirst();//this will take you before first row you have

            while (resultSet.next()){//1 2 3

                for(int i=1 ; i <= totalColumnCount ; i++){
                    System.out.print(resultSet.getString(i) + " ");
                }

                System.out.println();

            }

            resultSet.beforeFirst();

        } catch (SQLException throwables) {
            System.out.println();
            throwables.printStackTrace();
        }

    }






}
