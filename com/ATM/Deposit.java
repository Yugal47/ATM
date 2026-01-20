package com.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Deposit {
    Login log =new Login();
    public void deposit() throws Exception{
        Scanner sc = new Scanner(System.in);
        int userid= log.getUserid();//-->connects with that table
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        PreparedStatement ps1= con.prepareStatement("select * from users where user_id = ?");
        ps1.setInt(1, userid);
        ResultSet rs =ps1.executeQuery();
        if(rs.next()){
            System.out.println("--------------------------");
            System.out.print("Enter amount :");
            int amount= sc.nextInt();
            System.out.println("--------------------------");
            if(amount>=100){
                if(amount%5==0&&amount%5==5){
            PreparedStatement ps = con.prepareStatement("INSERT INTO atm (user_id, balance) VALUES (?, ?) ON DUPLICATE KEY UPDATE balance = balance + VALUES(balance);");
            ps.setInt(1,userid);
            ps.setInt(2,amount);
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("--------------------------");
                System.out.println("Deposited amount: "+ amount);
                System.out.println("--------------------------");
            }
            else{
                System.out.println("--------------------------");
                System.out.println("Failed to Deposit");
                System.out.println("--------------------------");
            }
        }
        System.out.println("You can deposit multiple of 50 and 100");
        }
        System.out.println("Minimum amount to be deposited is 100");
            // con.close();
            // ps.close();
            // ps1.close();
        }
    }
}
