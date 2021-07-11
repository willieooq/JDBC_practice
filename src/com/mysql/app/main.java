package com.mysql.app;

import com.mysql.db.*;

import java.sql.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("connecting...");
        //連線至DB
        Connect cdb = new Connect();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn =  cdb.getConnect();
            stmt = conn.createStatement();
            System.out.println("連線至資料庫成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("無法連線至資料庫");
        }
        int chioce = 0;
        do {
            System.out.println("1.透過E-mail查詢\n2.新增資料\n3.更新資料\n4.刪除資料\n5.離開本程式");
            //使用者輸入清單
            Scanner scanner = new Scanner(System.in);
            try {
                chioce = scanner.nextInt();
            }catch (Exception e){
                System.out.println("請輸入介於1~5的整數");
                scanner.nextLine();
            }
            switch (chioce){
                case 1:
                    //查詢
                    Select select = new Select();
                    select.setStmt(stmt);
                    select.select(scanner);
                    break;
                case 2:
                    //新增
                    Insert insert = new Insert();
                    insert.setStmt(stmt);
                    insert.insert(scanner);
                    break;
                case 3:
                    //更新資料
                    Update update = new Update();
                    update.setStmt(stmt);
                    update.update(scanner);
                    break;
                case 4:
                    //刪除資料
                    Delete delete = new Delete();
                    delete.setStmt(stmt);
                    delete.delete(scanner);
                    break;
                case 5:
                    //離開程式
                    break;
                default:
                    //輸入不是1~5
                    System.out.println("輸入錯誤 ");
            }
        }while (chioce != 5);//輸入5離開程式
        try{
            //關閉statement
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se){
        }// do nothing
        try{
            //關閉connection
            if(conn!=null)
                conn.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Goodbye!");
    }//end main

}//end class
