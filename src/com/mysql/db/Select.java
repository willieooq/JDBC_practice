package com.mysql.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select extends DataBase{

    private String input;
    public void select(Scanner scanner){
        String sql = "";
        //讀取輸入
        System.out.print("請輸入要查詢帳號的E-mail: ");
        input = scanner.next();
        try {
            sql = "SELECT * FROM memberaccount WHERE EMAIl = '"+input+"'";
            ResultSet rs = stmt.executeQuery(sql);
            //if data exist
            if(rs.next()){
                do{
                    //Retrieve by column name
                    int id  = rs.getInt("ID");
                    String email = rs.getString("EMAIL");
                    String password = rs.getString("PASSWORD");
                    String address = rs.getString("ADDRESS");
                    String cellphone = rs.getString("CELLPHONE");
                    String creat_date = rs.getString("CREATE_DATE");

                    //Display values
                    System.out.print("ID: " + id);
                    System.out.print(", Email: " + email);
                    System.out.print(", Password: " + password);
                    System.out.print(", Address: " + address);
                    System.out.print(", Cellphone: " + cellphone);
                    System.out.println(", Create date: "+creat_date);
                }while(rs.next());
            }
            else {
                System.out.println("查無資料");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error...");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        //end try
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}//end class
