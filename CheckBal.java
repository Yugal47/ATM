package com.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckBal {
    public void checkBal() throws Exception{
        Login log = new Login();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        int balance=0;
        int userid=log.getUserid();
        System.out.println(userid);

        PreparedStatement ps =con.prepareStatement("SELECT balance FROM atm where user_id=?");
        ps.setInt(1, userid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            balance=rs.getInt("balance");
            System.out.println(balance);
        }
        con.close();
        ps.close();
    }
}
