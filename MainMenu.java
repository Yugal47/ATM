package com.ATM;
import java.util.Scanner;
public class MainMenu {
    
    public int Balance=0;
    int menu;
    public void mainMenu() throws Exception{
        while(true){
        Scanner sc = new Scanner(System.in);
        System.out.println("========== ATM ===========");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Reset password");
        System.out.println("5. Exit");
        System.out.println("==========================");
        System.out.print("Enter your choice:");
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
                ResetPass res=new ResetPass();
                res.passwordReset();
            case 5:
                System.out.println("Exit");
                
                break;
            default:
                System.out.println("Invalid option");
        }
        if(menu==5) break;
    }
}

}
