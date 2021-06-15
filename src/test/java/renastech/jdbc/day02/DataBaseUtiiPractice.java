package renastech.jdbc.day02;

import renastech.jdbc.utils.DataBaseUtil;

public class DataBaseUtiiPractice {

    public static void main(String[] args) {

        //connection -statment -resultset

        DataBaseUtil.connectionDatabase();

        DataBaseUtil.runQuery("select * from jobs");

        String row5JobTitle=DataBaseUtil.getColumnDataFrowRow(5, "job_title");


        System.out.println("row5JobTitle = " + row5JobTitle);


        //this will count total column from jobs table which is 4
        System.out.println("DataBaseUtil.getTotalColumnCount() = " + DataBaseUtil.getTotalColumnCount());


        DataBaseUtil.getAllData();
    }
}
