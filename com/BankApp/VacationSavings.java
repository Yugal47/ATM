package com.BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class VacationSavings {
     int userid;
    VacationSavings(int userid) {
        this.userid = userid;
    }
    // @Override
    public void vacationSavings() throws Exception {
        Scanner sc = new Scanner(System.in);
        int amount;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement ps1 = con.prepareStatement("select * from user where user_id =?");
        ps1.setInt(1, userid);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println(" Enter the amount you want to deposit in Vacation Savings Account: ");
            amount = sc.nextInt();
            if (amount<=0){
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
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
            ps1.close();
            ps2.close();
            con.close();
        }
    }
}
