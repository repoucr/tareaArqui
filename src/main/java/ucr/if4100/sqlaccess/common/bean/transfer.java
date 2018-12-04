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
public class transfer {
    private String id;
    private int amount;
    private String detail;
    private String date;

    public transfer() {
    }

    public transfer(String id, int amount, String detail, String date) {
        this.id = id;
        this.amount = amount;
        this.detail = detail;
        this.date = date;
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

    @Override
    public String toString() {
        return "transfer{" + "id=" + id + ", amount=" + amount + ", detail=" + detail + ", date=" + date + '}';
    }
}
