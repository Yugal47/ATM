package com.BankApp;

import java.util.Scanner;
public class OpenAccount {
    Scanner sc = new Scanner(System.in);
    int choice;
    public void options(){
        System.out.println("Select the type of account you want to open:");
        System.out.println("1. Savings Account");
        System.out.println("2. Business Account");
        System.out.println("3. Joint Account");
        System.out.println("4. Fixed Deposit Account");
        System.out.println("5. Recurring Deposit Account");
        System.out.println("6. NRI Account");
        System.out.println("7. Senior Citizen Account");
        System.out.println("8. Student Account");
        System.out.println("9. Exit");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
    switch (choice){
        case 1:
            System.out.println("You have selected Savings Account.");
            SavingsAccount sa = new SavingsAccount();
            sa.accountDetails();
            break;
        case 2:
            System.out.println("You have selected Business Account.");
            break;
        case 3:
            System.out.println("You have selected Joint Account.");
            break;
        case 4:
            System.out.println("You have selected Fixed Deposit Account.");
            break;
        case 5:
            System.out.println("You have selected Recurring Deposit Account.");
            break;
        case 6:
            System.out.println("You have selected NRI Account.");
            break;
        case 7:
            System.out.println("You have selected Senior Citizen Account.");
            break;
        case 8:
            System.out.println("You have selected Student Account.");
            break;
        case 9:
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
    class JointAccount extends OpenAccount {
        Scanner sc = new Scanner(System.in);
        String name1, name2;
        public void accountDetails() {
            System.out.println(" Enter first account holder's name: ");
            name1 = sc.nextLine();
            System.out.println(" Enter second account holder's name: ");
            name2 = sc.nextLine();
            System.out.println("Joint Account created successfully for " + name1 + " and " + name2);
        }
    }

    public static void main(String[] args) {
        OpenAccount op = new OpenAccount();
        op .options();
    }
}
