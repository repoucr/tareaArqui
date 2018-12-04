/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.common.bean;

/**
 *
 * @author fabian
 */
public class account {
    private String id;
    private String number;
    private int accountBalance;
    private String currency;

    public account() {
    }

    public account(String id, String number, int accountBalance, String currency) {
        this.id = id;
        this.number = number;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "account{" + "id=" + id + ", number=" + number + ", accountBalance=" + accountBalance + ", currency=" + currency + '}';
    }
}
