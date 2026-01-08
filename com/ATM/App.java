package com.ATM;
public class App {
    public static void main(String[] args) {
        Login login = new Login();

        try {
            login.login1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}