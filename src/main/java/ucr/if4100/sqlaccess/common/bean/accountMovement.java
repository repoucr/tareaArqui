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
public class accountMovement {
    private String idMovement;
    private String idAccount;
    private String numberAccount;

    public accountMovement() {
    }

    public accountMovement(String idMovement, String idAccount, String numberAccount) {
        this.idMovement = idMovement;
        this.idAccount = idAccount;
        this.numberAccount = numberAccount;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
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
        return "accountMovement{" + "idMovement=" + idMovement + ", idAccount=" + idAccount + ", numberAccount=" + numberAccount + '}';
    }
}
