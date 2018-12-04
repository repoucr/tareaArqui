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

    public movement() {
    }

    public movement(String id, int amount, String date, String detail) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.detail = detail;
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

    @Override
    public String toString() {
        return "movement{" + "id=" + id + ", amount=" + amount + ", date=" + date + ", detail=" + detail + '}';
    }
}
