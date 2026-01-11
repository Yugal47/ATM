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
        // int i =ps1.executeUpdate();
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            userid = rs1.getInt("user_id");
            // System.out.println(userid);
            // displaySavingsAccountOptions();

        }
    }

    public void displaySavingsAccountOptions() throws Exception{
        Scanner sc = new Scanner(System.in);
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
                SavingsAccount ps = new PersonalSavings();
                ps.accountDetails();
                accountDetails();
                break;
            case 2:
                accountDetails();
                break;
            case 3:
                accountDetails();
                break;
            case 4:
                accountDetails();
                break;
            default:
                System.out.println(" Invalid choice. Please try again.");
                break;
            }
    }
    
}

class PersonalSavings extends SavingsAccount {
    // @Override
    public void personalSavings() throws Exception {
        Scanner sc = new Scanner(System.in);
        userid = getUserid();
        int amount;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select * from user where user_id =?");
        ps1.setInt(1, userid);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println(" Enter the amount you want to deposit in Personal Savings Account: ");
            amount = sc.nextInt();
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO savingsAccount (user_id,PersonalSavings) VALUES (?,?)  ON DUPLICATE KEY UPDATE PersonalSavings = PersonalSavings + values(PersonalSavings);");
            ps2.setInt(1, userid);
            ps2.setInt(2, amount);
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully deposited " + amount + " in Personal Savings Account.");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        }
    }
}

class VacationSavings extends SavingsAccount {
    // @Override
    public void vacationSavings() throws Exception {
        Scanner sc = new Scanner(System.in);
        userid = getUserid();
        int amount;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select * from user where user_id =?");
        ps1.setInt(1, userid);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println(" Enter the amount you want to deposit in Vacation Savings Account: ");
            amount = sc.nextInt();
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO savingsAccount (user_id,VacationSavings) VALUES (?,?)  ON DUPLICATE KEY UPDATE VacationSavings = VacationSavings + values(VacationSavings);");
            ps2.setInt(1, userid);
            ps2.setInt(2, amount);
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully deposited " + amount + " in Vacation Savings Account.");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        }
    }

}

class EmergencySavings extends SavingsAccount {
    public void accountDetails() throws Exception {
        Scanner sc = new Scanner(System.in);
        userid = getUserid();
        int amount;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select * from user where user_id =?");
        ps1.setInt(1, userid);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println(" Enter the amount you want to deposit in Emergency Savings Account: ");
            amount = sc.nextInt();
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO savingsAccount (user_id,EmergencySavings) VALUES (?,?)  ON DUPLICATE KEY UPDATE EmergencySavings = EmergencySavings + values(EmergencySavings);");
            ps2.setInt(1, userid);
            ps2.setInt(2, amount);
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully deposited " + amount + " in Emergency Savings Account.");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        }
    }
}

class NewCarSavings extends SavingsAccount {
    public void accountDetails() throws Exception {
        Scanner sc = new Scanner(System.in);
        userid = getUserid();
        int amount;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select * from user where user_id =?");
        ps1.setInt(1, userid);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println(" Enter the amount you want to deposit in New Car Savings Account: ");
            amount = sc.nextInt();
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO savingsAccount (user_id,NewCarSavings) VALUES (?,?)  ON DUPLICATE KEY UPDATE NewCarSavings = NewCarSavings + values(NewCarSavings);");
            ps2.setInt(1, userid);
            ps2.setInt(2, amount);
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully deposited " + amount + " in New Car Savings Account.");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        }
    }
}
