package com.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckBal {
    public void checkBal(Login log) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        int balance=0;
        int userid=log.getUserid();

        PreparedStatement ps =con.prepareStatement("SELECT balance FROM atm where user_id=?");
        ps.setInt(1, userid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            balance=rs.getInt("Balance");
            System.out.println(balance);
        }
    }
    public static void main(String[] args) {
        Login log1 = new Login();
        
    }
    public void checkBal(MainMenu log) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkBal'");
    }
}
