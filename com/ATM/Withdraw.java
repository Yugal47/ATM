package com.ATM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Withdraw {
    Login log =new Login();
    public void debit() throws Exception{
        Scanner sc =new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.print("Enter Amout :");
        int amount = sc.nextInt();
        System.out.println("--------------------------");
        int bal=0;
        int userid=log.getUserid();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        String RdSql="SELECT balance FROM atm where user_id=?";
        PreparedStatement ps2 = con.prepareStatement(RdSql);
        ps2.setInt(1, userid);
        ResultSet j = ps2.executeQuery();
        if(j.next()){
            bal=j.getInt("Balance");
        }

        if(bal>=amount){
            String upSql="UPDATE atm SET balance = balance-? where user_id=?";
            PreparedStatement ps1 = con.prepareStatement(upSql);
            ps1.setInt(1, amount);
            ps1.setInt(2, userid);
            int i = ps1.executeUpdate();
            if(i>0){
                System.out.println("Collect Your Money");
                System.out.println("--------------------------");
            }
            else System.out.println("Failed");
            con.close();
            ps1.close();
            sc.close();
        }
        else{
            System.out.println("Insufficent balance");
            System.out.println("--------------------------");
        }
        con.close();
        ps2.close();

    }
}
