package com.mysql.db;

import java.sql.SQLException;
import java.util.Scanner;

public class Insert extends DataBase {

    public void insert(Scanner scanner) {
        //使用者輸入參數
        String[] inputs = new String[4];
        String sql = "";
        System.out.println("新增用戶資料");
        for(int i = 0;i<4;i++){
            switch (i){
                case 0:
                    System.out.print("請輸入Email: ");
                    break;
                case 1:
                    System.out.print("請輸入密碼: ");
                    break;
                case 2:
                    System.out.print("請輸入地址: ");
                    break;
                case 3:
                    System.out.print("請輸入手機號碼: ");
                    break;
            }
            inputs[i] = scanner.next();
        }//end for
        //sql語法
        sql = "INSERT INTO memberaccount VALUES"+
                " (NULL, '"+inputs[0]+"', '"+inputs[1]+"', '"+inputs[2]+"', '"+inputs[3]+"', NOW())";
        try {
            //sql execute
            stmt.executeUpdate(sql);
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println("Error...");
            e.printStackTrace();
        }//end try
    }
}//end class
