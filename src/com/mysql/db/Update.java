package com.mysql.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update extends DataBase{
    public void update(Scanner scanner){
        String sql = "";
        //使用者選擇
        int choice = 0;
        String input = "";
        String email = "";
        //1.E-mail 2.password 3.Address 4.Account
        String[] choices = {"EMAIL","PASSWORD","ADDRESS","ACCOUNT"};

        try {
            System.out.println("Update data\n請輸入要更改資料的E-mail");
            //拿email查找是否有該筆資料
            email = scanner.next();
            sql = "SELECT * FROM memberaccount WHERE EMAIl = '"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
            //如果資料存在
            if(rs.next()){
                System.out.println("請選擇要更新的項目:\n1.E-mail\n2.password\n3.Address\n4.Account");
                //如果是輸入是數字
                if (scanner.hasNextInt()){
                    do{
                        System.out.println("請輸入介於1~4的值");
                        choice = scanner.nextInt();
                    }while (choice<1 || choice>4);
                    System.out.println("請輸入要修改的值");
                    input = scanner.next();
                    try {
                        //sql語法
                        sql = "UPDATE memberaccount " +
                                "SET "+choices[choice-1]+" = '"+input+"' WHERE EMAIL = '"+email+"'";
                        //sql執行update
                        stmt.executeUpdate(sql);
                        System.out.println("update Success");
                    }catch (SQLException e) {
                        //handle exception
                        System.out.println("發生錯誤");
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }//end try
                }
                else {
                    System.out.println("請輸入介於1~4的值");
                    scanner.nextLine();
                }//end if
            }
            else {
                System.out.println("找不到資料");
            }//end if
        }catch (SQLException e){
            System.out.println("發生錯誤");
            e.printStackTrace();
        }//end try
    }
}//end class
