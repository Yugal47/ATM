package com.BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SavingsAccount {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void accountDetails() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter your name: ");
        name = sc.nextLine();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select user_id from user where Name =?");
        ps1.setString(1, name);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            userid = rs1.getInt("user_id");            
        }
    }

    public void displaySavingsAccountOptions() throws Exception{
        Scanner sc = new Scanner(System.in);
        accountDetails();
        System.out.println(" Savings Account Types: ");
        System.out.println(" 1. Personal Savings Account ");
        System.out.println(" 2. Vacation Savings Account ");
        System.out.println(" 3. Emergency Savings Account ");
        System.out.println(" 4. New Car Savings Account ");
        System.out.print(" Choose the type of Savings Account you want to deposit into (1-4): ");
        int ch = sc.nextInt();
        // int ch = 1;
        switch (ch) {
            case 1:
                new PersonalSavings(userid).personalSavings();
                break;
            case 2:
                new VacationSavings(userid).vacationSavings();
                break;
            case 3:
                new EmergencySavings(userid).emergencySavings();
                break;
            case 4:
                new NewCarSavings(userid).newCarSavings();
                break;
            default:
                System.out.println(" Invalid choice. Please try again.");
                break;
        }
    }
    
}



