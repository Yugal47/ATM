package com.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ResetPass {
    Login log =new Login();
    
    public void passwordReset() throws Exception{
        Scanner sc =new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        int uid = log.getUserid();
        
        PreparedStatement ps1 = con.prepareStatement("select user_id from users where user_id=?");
        ps1.setInt(1, uid);
        ResultSet rs = ps1.executeQuery();
        if(rs.next()){
            uid = rs.getInt("user_id");
            System.out.print("Enter your new password:");
            String pass=sc.next();
            System.out.println(uid);
            PreparedStatement ps2 =con.prepareStatement("Update users set password =? where user_id =?");
            ps2.setString(1, log.hashPassword(pass));
            ps2.setInt(2, uid);
            int i =ps2.executeUpdate();
            if (i>0){
                System.out.println("Changed");
            }
            else System.out.println("failed");
            ps1.close();
            ps2.close();
        }
        con.close();
 
    }
}
