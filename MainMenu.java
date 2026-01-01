package com.ATM;
import java.util.Scanner;
public class MainMenu {
    
    public int Balance=0;
    int menu;
    public void mainMenu() throws Exception{
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
                cb.checkBal();
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
       

    }
}
