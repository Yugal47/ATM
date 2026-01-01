package com.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class MainMenu {
    
    public int Balance=1000;
    
    public int getBalance() {
        return Balance;
    }
    public void setBalance(int Balance) {
        this.Balance = Balance;
    }
    int menu;
    public void mainMenu() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        // PreparedStatement ps = con.prepareStatement("INSERT INTO ATM VALUES(?)");
        // ps.setInt(1,Balance);
        while(true){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        menu=sc.nextInt();
        switch(menu){
            case 1:
                Withdraw w = new Withdraw();
                w.debit();
                break;
            case 2:
                Deposit d =new Deposit();
                d.deposit();
                break;
            case 3:
                CheckBal cb = new CheckBal();                
                cb.checkBal(this);
                break;
            case 4:
                System.out.println("Exit");
                
                break;
            default:
                System.out.println("Invalid option");
        }
        if(menu==4) break;
    }
}
    public static void main(String[] args)  {
    try {
        new MainMenu().mainMenu();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println("done");
    // me.mainMenu();        

    }
}
