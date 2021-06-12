package renastech.jdbc.day01_part2;

import renastech.jdbc.utils.DataBaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class c2_Practice {

    public static void main(String[] args) throws SQLException {


        //connection-stament-resultset
        //and if we need it resultsetmetadata

        DataBaseUtil.connectionDatabase();
//        ResultSet resultSet=DataBaseUtil.runQuery("select * from employees");
        ResultSet resultSet=DataBaseUtil.runQuery("select * from regions");

        int totalColumnCount=DataBaseUtil.getTotalColumnCount();
        System.out.println("totalColumnCount = " + totalColumnCount);

        //display all data from query that you run

        resultSet.beforeFirst();//0

        while (resultSet.next()){// 1 2 3 4
            //this will look at row number and move each time until last one

            for (int i=1 ; i<= totalColumnCount ; i++){ // 1 2
                System.out.print(resultSet.getString(i) + " ");

                //while cursor is on row 1
                //i=1
                //row 1 column 1
                //i=2
                //row 1 column 2



                //while cursor is on row 2
                //i=1
                //row 2 column 1
                //i=2
                //row 2 column 2

            }
            System.out.println();


        }
    }
}
