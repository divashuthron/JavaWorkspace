package com.java.project.es;

public class Account implements Comparable<Account> {
    private String id;
    private int balance;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //입금
    public void desposit(int cash) {
        balance += cash;
    }

    //출금
    public void withdrawal(int cash) {
        if (balance >= cash) {
            balance -= cash;
        } else {
            System.out.println("잔고 부족");
        }
    }

    @Override
    public int compareTo(Account o) {
        return (this.name.compareTo(o.name));
    }
}
