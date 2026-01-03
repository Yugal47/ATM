package com.ATM;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

    public static int userid;

    public int getUserid() {
        return userid;
    }

    
    int user_id;
    public void login1() throws Exception {
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        System.out.println("+++++++++ Welcome +++++++++");
        System.out.println("+      1. To Login        +");
        System.out.println("+      2. To Register     +");
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();
        System.out.print("Enter your choice :");
        int choice = sc.nextInt();
        System.out.println();
        
        String Uname = "";
        String Pin = "";
        
        if (choice == 1) {
            System.out.print("Enter your User Name: ");
            Uname = sc.next();

            PreparedStatement ps3 =con.prepareStatement("select user_id from users where username=?");
            ps3.setString(1, Uname);
            ResultSet rs1=ps3.executeQuery();
            if(rs1.next()){
                userid=rs1.getInt("user_id");
            }
            System.out.print("Enter your Pin: ");
            Pin = sc.next();
            
            PreparedStatement ps = con.prepareStatement(
                    "SELECT 1 FROM users WHERE username=? AND password=?");

            ps.setString(1, Uname);
            ps.setString(2, hashPassword(Pin));

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                MainMenu menu = new MainMenu();
                menu.mainMenu();
                
            } else {
                System.out.println("Credentials didn't matched!!");
            }
            
            rs.close();
            ps.close();
            
        } else if (choice == 2) {
            
            System.out.print("Enter your User Name: ");
            Uname = sc.next();
            
            System.out.print("Enter your password: ");
            Pin = sc.next();
            
            String regNameTest="INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps2 = con.prepareStatement(regNameTest);
            
            ps2.setString(1, Uname);
            ps2.setString(2, hashPassword(Pin));
            int reg1 = ps2.executeUpdate();
            PreparedStatement ps1 =con.prepareStatement("select user_id from users where username=?");
            ps1.setString(1, Uname);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next()){
                userid=rs1.getInt("user_id");
                System.out.println("Your userid is:"+userid);
                System.out.println("Use this ID to log-in next time");
            }
            
            
            if (reg1 > 0) {
                System.out.println("User Registered Successfully");
            } else {
                System.out.println("Failed to Register");
            }
            
            ps1.close();
            
        } else {
            System.out.println("Invalid Option!!");
        }
        
        con.close();
        sc.close();
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    public static String hashPassword(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(pin.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

