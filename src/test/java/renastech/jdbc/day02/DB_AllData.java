package renastech.jdbc.day02;

import renastech.jdbc.utils.DataBaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_AllData {

    public static void main(String[] args) throws SQLException {
        //connection -- statement -resultset

        DataBaseUtil.connectionDatabase();

        //statment
        ResultSet rs=DataBaseUtil.runQuery("select * from employees");

        System.out.println("DataBaseUtil.getTotalColumnCount() = " + DataBaseUtil.getTotalColumnCount());

        rs.absolute(10);


        DataBaseUtil.getAllData();

        rs.next();//afterlast
        System.out.println("rs.getString(1) = " + rs.getString(1));

        //print me specific row and column value
        //ex : row number 25 and print last name
        //expected output : Mourgos



    }
}
