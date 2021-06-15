package renastech.jdbc.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import renastech.jdbc.utils.DataBaseUtil;

public class c3_PracticeJunit {


    @BeforeAll
    public static void createConnection(){
        //connection
        DataBaseUtil.connectionDatabase();
    }


    //print row number 15 column job_id from jobs table
    @Test
    public void TC1_printRow15ColumnJobIDFromJOBS(){
        //statment resultset run querry
        DataBaseUtil.runQuery("select * from jobs");

        String itProg=DataBaseUtil.getColumnDataFrowRow(15,"job_id");

        System.out.println(itProg);

        Assertions.assertEquals("IT_PROG" , DataBaseUtil.getColumnDataFrowRow(15 ,"job_id" ));

    }

    @Test
    public void TC2_totalColumnCountJobs(){
        //statment resultset
        DataBaseUtil.runQuery("select * from jobs");

        System.out.println("DataBaseUtil.getTotalColumnCount() = " + DataBaseUtil.getTotalColumnCount());


    }

    @Test
    public void TC3_totalColumnCountEmployees(){
        //statment resultset
        DataBaseUtil.runQuery("select * from employees");

        System.out.println("DataBaseUtil.getTotalColumnCount() = " + DataBaseUtil.getTotalColumnCount());


    }

}
