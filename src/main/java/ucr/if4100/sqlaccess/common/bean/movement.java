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
public class movement {
    private String id;
    private int amount;
    private String date;
    private String detail;
    private String idAccount;
    private String idClient;
    private String clientName;

    public movement() {
    }

    public movement(String id, int amount, String date, String detail, String idAccount, String idClient, String clientName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.detail = detail;
        this.idAccount = idAccount;
        this.idClient = idClient;
        this.clientName = clientName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "movement{" + "id=" + id + ", amount=" + amount + ", date=" + date + ", detail=" + detail + ", idAccount=" + idAccount + ", idClient=" + idClient + ", clientName=" + clientName + '}';
    }

    
}
