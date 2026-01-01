package com.ATM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Withdraw {
    
    public void debit() throws Exception{
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Amout:");
        int amount = sc.nextInt();
        int bal=0;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        String RdSql="SELECT*FROM ATM";
        PreparedStatement ps2 = con.prepareStatement(RdSql);
        ResultSet j = ps2.executeQuery();
        if(j.next()){
            bal=j.getInt("Balance");
        }

        if(bal>=amount){//db se balance ko bula ke usse minus karwana padega
            String upSql="UPDATE ATM SET Balance = Balance-?";
            PreparedStatement ps1 = con.prepareStatement(upSql);
            ps1.setInt(1, amount);
            int i = ps1.executeUpdate();
        }
        else{
            System.out.println("Insufficent balance");
        }

    }
}
