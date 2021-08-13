package com.company.bank;

import com.company.Person;

import java.util.UUID;

public class BankAccount {
    private final String id;
    private int transactionCounter = 0;

    public int getTransactionCounter() {
        return transactionCounter;
    }

    public void setTransactionCounter(int transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public String getId() {
        return id;
    }

    private long balance;

    private String[] transactionsHistory;

    public String[] getTransactionsHistory() {
        return transactionsHistory;
    }

    void setTransactionsHistory(String[] transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }

    public final Person owner;

    BankAccount(long balance, Person owner) {
        this.id = generateUniqueId();
        this.balance = balance;
        this.transactionsHistory = new String[]{"No transaction yet", "No transaction yet", "No transaction yet", "No transaction yet", "No transaction yet"};
        this.owner = owner;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public long getBalance() {
        return balance;
    }

    void setBalance(long balance) {
        this.balance = balance;
    }

    public void addTransaction(String transaction){
        if(transactionCounter == 5){
            transactionCounter = 0;
        }
        transactionsHistory[transactionCounter] = transaction;
        transactionCounter++;
    }

    public Person getOwner() {
        return owner;
    }
}
