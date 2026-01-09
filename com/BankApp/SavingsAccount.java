package com.BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SavingsAccount {
    public void accountDetails() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Scanner sc = new Scanner(System.in);
        String name;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        PreparedStatement ps = con.prepareStatement("INSERT INTO bank_accounts (name, account_type) VALUES (?, ?)");
            System.out.println(" Enter your name: ");
            name = sc.nextLine();
            System.out.println("Account created successfully for " + name);
        }
}
class PersonalSavings extends SavingsAccount {
    
}
class VacationSavings extends SavingsAccount {
    
}
class EmergencySavings extends SavingsAccount {
    
}
class NewCarSavings extends SavingsAccount {
    
}