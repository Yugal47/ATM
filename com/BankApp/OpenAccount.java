package com.BankApp;

class OpenAccount {
    int choice;
    public void options(){
        System.out.println("==========================");
        System.out.println("1. Personal Savings Account");
        System.out.println("2. Business Account");
        System.out.println("3. Joint Account");
        System.out.println("4. Fixed Deposit Account");
        System.out.println("5. Recurring Deposit Account");
        System.out.println("6. NRI Account");
        System.out.println("7. Senior Citizen Account");
        System.out.println("8. Student Account");
        System.out.println("9. Exit");
        System.out.println("==========================");
        System.out.println("Enter your choice:");
    }
    public void account() {
        options();
        switch (choice){
            case 1:
                System.out.println("You have selected Personal Savings Account.");
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
                break;
        }
        
    }
    public static void main(String[] args) {
        OpenAccount op = new OpenAccount();
        op.account();
}
}