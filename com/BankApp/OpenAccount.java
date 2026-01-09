package com.BankApp;

import java.util.Scanner;
public class OpenAccount {
    Scanner sc = new Scanner(System.in);
    int choice;
    public void options(){
        System.out.println("Select the type of account you want to open:");
        System.out.println("1. Savings Account");
        System.out.println("2. Business Account");
        System.out.println("3. Exit");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
    switch (choice){
        case 1:
            System.out.println("You have selected Savings Account.");
            SavingsAccount sa = new SavingsAccount();
            sa.accountDetails();
            break;
        case 2:
            BusinessAccount ba = new BusinessAccount();
            System.out.println("You have selected Business Account.");
            ba.accountDetails();
            break;
        case 3:
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
    }
    class SavingsAccount extends OpenAccount {
        Scanner sc = new Scanner(System.in);
        String name;
        public void accountDetails() {
            System.out.println(" Enter your name: ");
            name = sc.nextLine();
            System.out.println("Account created successfully for " + name);
        }
    }
    class BusinessAccount extends OpenAccount {
        Scanner sc = new Scanner(System.in);
        String name;
        public void accountDetails() {
            System.out.println(" Enter your name: ");
            name = sc.nextLine();
            System.out.println("Account created successfully for " + name);
        }
    }
    

    public static void main(String[] args) {
        OpenAccount op = new OpenAccount();
        op .options();
    }
}
