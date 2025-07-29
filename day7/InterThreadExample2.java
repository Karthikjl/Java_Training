package com.celcom.day7;

import java.util.Scanner;

class BankAccount {
    private int balance;


    public BankAccount(int balance) {
        this.balance = balance;
    }
    
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", Balance: " + balance);
    }


    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private int depositAmount;


    public DepositThread(BankAccount account, int depositAmount) {
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        account.deposit(depositAmount); 
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private int withdrawalAmount;


    public WithdrawalThread(BankAccount account, int withdrawalAmount) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        account.withdraw(withdrawalAmount); 
    }
}

public class InterThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter initial balance: ");
        int initialBalance = scanner.nextInt();

        System.out.print("Enter deposit amount: ");
        int depositAmount = scanner.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int withdrawalAmount = scanner.nextInt();


        BankAccount account = new BankAccount(initialBalance);


        DepositThread depositThread = new DepositThread(account, depositAmount);
        WithdrawalThread withdrawalThread = new WithdrawalThread(account, withdrawalAmount);


        depositThread.start();


        Thread.sleep(2000);


        withdrawalThread.start();


        depositThread.join();
        withdrawalThread.join();


        scanner.close();
    }
}
