package com.company;

import com.company.Person;
import com.company.bank.BankAccount;
import com.company.bank.BankAccountManager;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person pers1 = new Person("Natan1", "Chachko", 18);
        Person pers2 = new Person("Natan2", "Chachko", 18);
        Person pers3 = new Person("Natan3", "Chachko", 18);
        Person pers4 = new Person("Natan4", "Chachko", 18);
        Person pers5 = new Person("Natan5", "Chachko", 18);
        Person pers6 = new Person("Natan6", "Chachko", 18);
        Person pers7 = new Person("Natan7", "Chachko", 18);
        Person pers8 = new Person("Natan8", "Chachko", 18);
        Person pers9 = new Person("Natan9", "Chachko", 18);
        Person pers10 = new Person("Natan10", "Chachko", 18);
        Person pers11 = new Person("Natan11", "Chachko", 18);
        Person pers12 = new Person("Natan12", "Chachko", 18);
        Person pers13 = new Person("Natan13", "Chachko", 18);
        Person pers14 = new Person("Natan14", "Chachko", 18);
        Person pers15 = new Person("Natan15", "Chachko", 18);

        BankAccountManager bankAccountManager = new BankAccountManager();

        BankAccount bankAccount8 = bankAccountManager.createBankAccount(150, pers8);
        BankAccount bankAccount9 = bankAccountManager.createBankAccount(0, pers9);
        BankAccount bankAccount10 = bankAccountManager.createBankAccount(0, pers10);
        BankAccount bankAccount11 = bankAccountManager.createBankAccount(0, pers11);
        BankAccount bankAccount12 = bankAccountManager.createBankAccount(0, pers12);

        bankAccountManager.addBankAccount(bankAccount8);
        bankAccountManager.addBankAccount(bankAccount9);
        bankAccountManager.addBankAccount(bankAccount10);
        bankAccountManager.addBankAccount(bankAccount11);
        bankAccountManager.addBankAccount(bankAccount12);


        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers1));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers2));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers3));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers4));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers5));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers6));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers7));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers13));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers14));
        bankAccountManager.addBankAccount(bankAccountManager.createBankAccount(0, pers15));

        System.out.println(bankAccount8.getId());
        System.out.println(bankAccountManager.findBankAccountById(bankAccount8.getId()).getId());
        String id8 = bankAccount8.getId();
        System.out.println("Balance: " + bankAccount8.getBalance());
        bankAccountManager.putOnBankAccountById(bankAccount8.getId(), 150);
        System.out.println("Balance: " + bankAccount8.getBalance());
        System.out.println("Balance of 9: " + bankAccount9.getBalance());
        bankAccountManager.transferMoneyBetweenTwoAccounts(bankAccount8.getId(), 20, bankAccount9.getId());
        System.out.println("Balance: " + bankAccount8.getBalance());
        System.out.println("Balance of 9: " + bankAccount9.getBalance());
        bankAccountManager.transferMoneyBetweenTwoAccounts(bankAccount9.getId(), 10, bankAccount8.getId());
        System.out.println("Balance: " + bankAccount8.getBalance());
        System.out.println("Balance of 9: " + bankAccount9.getBalance());

        System.out.println("\nTry..........................................\n");

        System.out.println(Arrays.toString(bankAccount9.getTransactionsHistory()));

        System.out.println(Arrays.toString(bankAccountManager.getAccounts()));
        System.out.println(bankAccountManager.deleteBankAccountById(bankAccount8.getId()));
        bankAccountManager.deleteBankAccountById("-----WRONG ID-----");
        System.out.println(bankAccountManager.findBankAccountById(id8));
        System.out.println(Arrays.toString(bankAccount9.getTransactionsHistory()));
        System.out.println(Arrays.toString(bankAccount8.getTransactionsHistory()));

    }
}
