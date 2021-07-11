package com.mysql.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete extends DataBase{
    public void delete(Scanner scanner) {
        String sql = "";
        String email = "";
        try {
            System.out.print("請輸入要刪除資料的Email: ");
            //拿email查找是否有該筆資料
            email = scanner.next();
            sql = "SELECT * FROM memberaccount WHERE EMAIl = '" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //如果資料存在
            if (rs.next()) {
                sql = "DELETE FROM memberaccount " +
                        "WHERE EMAIL = '" + email + "'";
                stmt.executeUpdate(sql);
                System.out.println("Success");
            } else {
                System.out.println("資料不存在");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("發生錯誤");
            e.printStackTrace();
        }//end try
    }
}//end class
