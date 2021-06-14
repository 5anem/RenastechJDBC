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
    }
}
