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
public class record {
    
    private String id;
    private String number;
    private String clientName;
    private String detail;
    private String date;
    private String amount;
    private String currency;

    public record() {
    }

    public record(String id, String number, String clientName, String detail, String date, String amount, String currency) {
        this.id = id;
        this.number = number;
        this.clientName = clientName;
        this.detail = detail;
        this.date = date;
        this.amount = amount;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "record{" + "id=" + id + ", number=" + number + ", clientName=" + clientName + ", detail=" + detail + ", date=" + date + ", amount=" + amount + ", currency=" + currency + '}';
    }
    
}
