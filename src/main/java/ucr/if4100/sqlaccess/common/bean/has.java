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
public class has {
    private String idClient;
    private String nameClient;
    private String idAccount;
    private String numberAccount;

    public has() {
    }

    public has(String idClient, String nameClient, String idAccount, String numberAccount) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.idAccount = idAccount;
        this.numberAccount = numberAccount;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    @Override
    public String toString() {
        return "has{" + "idClient=" + idClient + ", nameClient=" + nameClient + ", idAccount=" + idAccount + ", numberAccount=" + numberAccount + '}';
    }
}
