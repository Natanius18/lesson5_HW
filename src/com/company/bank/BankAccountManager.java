package com.company.bank;

import com.company.Person;

public class BankAccountManager {
    private BankAccount[] accounts = new BankAccount[10];
    private int currentAmount = 0;
    private int maxAmount = 10;

    public BankAccount[] getAccounts() {
        return accounts;
    }


    public BankAccount createBankAccount(long balance, Person owner){
        return new BankAccount(balance, owner);
    }
    public BankAccount addBankAccount(BankAccount bankAccount) {
        if (maxAmount - currentAmount == 1) {
            System.out.println("New mass!!!!!!!!");
            maxAmount = currentAmount + 5;
            BankAccount[] tmp = new BankAccount[maxAmount];
            System.arraycopy(accounts, 0, tmp, 0, accounts.length);
            accounts = tmp;
        }
        accounts[currentAmount++] = bankAccount;
        return bankAccount;
    }

    private int findIndexOfBankAccountById(String id) {
        for (int i = 0; i < accounts.length - 1; i++) {
            if (accounts[i] == null) {
                return -1;
            }
            if (accounts[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public BankAccount findBankAccountById(String id) {
        int indexOfBankAccountById = findIndexOfBankAccountById(id);
        return indexOfBankAccountById != -1 ? accounts[indexOfBankAccountById] : null;
    }

    public boolean deleteBankAccountById(String id) {
        int index = findIndexOfBankAccountById(id);
        if (index == -1) {
            System.out.println("Account with such id doesn't exist!");
            return false;
        }
        accounts[index] = accounts[currentAmount];
        accounts[currentAmount] = null;
        currentAmount--;

        if (maxAmount - currentAmount == 5) {
            maxAmount = maxAmount - 3;
            BankAccount[] tmp = new BankAccount[maxAmount];
            System.arraycopy(accounts, 0, tmp, 0, maxAmount);
            accounts = tmp;
        }

        System.out.println("Element with id " + id + " was deleted successfully");
        return true;
    }

    public void putOnBankAccountById(String id, long amount){
        if (amount <= 0) System.out.println("Not enough money");
        else {
            int index = findIndexOfBankAccountById(id);
            if (index == -1) {
                System.out.println("Account with such id doesn't exist!");
            }
            else{
                BankAccount currentAccount = accounts[index];
                currentAccount.setBalance(currentAccount.getBalance() + amount);
                currentAccount.addTransaction("The account was replenished by " + amount + "$");
            }
        }
    }

    public void transferMoneyBetweenTwoAccounts(String idOfSender, int amount,  String idOfRecipient){
        BankAccount sender = findBankAccountById(idOfSender);
        BankAccount recipient = findBankAccountById(idOfRecipient);
        int index1 = findIndexOfBankAccountById(idOfSender);
        int index2 = findIndexOfBankAccountById(idOfRecipient);
        if (index1 == -1 || index2 == -1 || index1 == index2) {
            System.out.println("Wrong id!");
        }
        else{
            if (sender.getBalance() < amount){
                System.out.println("Not enough money to transfer!");
                sender.addTransaction("Failed transaction.");
            }
            else {
                sender.setBalance(sender.getBalance() - amount);
                recipient.setBalance(recipient.getBalance() + amount);
                sender.addTransaction(amount + "$ were sent to " + recipient.getOwner().getName());
                recipient.addTransaction(amount + "$ were received from " + sender.getOwner().getName());
            }
        }

    }
}