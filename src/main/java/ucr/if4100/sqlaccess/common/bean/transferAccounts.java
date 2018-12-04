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
public class transferAccounts {
    private String idTransfer;
    private String idAccountToDebit;
    private String idAccountToCredit;
    private String numberAccountToDebit;
    private String numberAccountToCredit;

    public transferAccounts() {
    }

    public transferAccounts(String idTransfer, String idAccountToDebit, String idAccountToCredit, String numberAccountToDebit, String numberAccountToCredit) {
        this.idTransfer = idTransfer;
        this.idAccountToDebit = idAccountToDebit;
        this.idAccountToCredit = idAccountToCredit;
        this.numberAccountToDebit = numberAccountToDebit;
        this.numberAccountToCredit = numberAccountToCredit;
    }

    public String getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(String idTransfer) {
        this.idTransfer = idTransfer;
    }

    public String getIdAccountToDebit() {
        return idAccountToDebit;
    }

    public void setIdAccountToDebit(String idAccountToDebit) {
        this.idAccountToDebit = idAccountToDebit;
    }

    public String getIdAccountToCredit() {
        return idAccountToCredit;
    }

    public void setIdAccountToCredit(String idAccountToCredit) {
        this.idAccountToCredit = idAccountToCredit;
    }

    public String getNumberAccountToDebit() {
        return numberAccountToDebit;
    }

    public void setNumberAccountToDebit(String numberAccountToDebit) {
        this.numberAccountToDebit = numberAccountToDebit;
    }

    public String getNumberAccountToCredit() {
        return numberAccountToCredit;
    }

    public void setNumberAccountToCredit(String numberAccountToCredit) {
        this.numberAccountToCredit = numberAccountToCredit;
    }

    @Override
    public String toString() {
        return "transferAccounts{" + "idTransfer=" + idTransfer + ", idAccountToDebit=" + idAccountToDebit + ", idAccountToCredit=" + idAccountToCredit + ", numberAccountToDebit=" + numberAccountToDebit + ", numberAccountToCredit=" + numberAccountToCredit + '}';
    }
}
