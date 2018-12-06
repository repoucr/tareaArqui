/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.transferAccounts;
import ucr.if4100.sqlaccess.data.TransferAccountData;

/**
 *
 * @author fabian
 */
public class TransferAccountBiz {
    private TransferAccountData _dataAccess;
    
    public TransferAccountBiz(){
        this._dataAccess = new TransferAccountData();
    }
    public  List<transferAccounts> getTransferAccounts() {
        return _dataAccess.getTransferAccount();
    }
    
    public void insertTransferAccount(String idAccount, String idAccountToDebit, String idAccountToCredit,String numberAccountToDebit,String numberAccountToCredit){
        _dataAccess.insertTransferAccount(idAccount, idAccount, idAccountToCredit, numberAccountToDebit, numberAccountToCredit);
               
    }
    
    public void deleteTransferAccountByIdTransfer(String id){
        _dataAccess.deleteTransferAccountByIdTransfer(id);
    }
    public void deleteTransferAccountByIdAccountToDebit(String id){
        _dataAccess.deleteTransferAccountByIdAccountToDebit(id);
    }
    
    public void deleteTransferAccountByIdAccountToCredit(String id){
        _dataAccess.deleteTransferAccountByIdAccountToCredit(id);
    }
    
    public void deleteTransferAccountByNumberAccountToDebit(String number){
         _dataAccess.deleteTransferAccountByNumberAccountToDebit(number);
    }
    
    public void deleteTransferAccountByNumberAccountToCredit(String number){
         _dataAccess.deleteTransferAccountByNumberAccountToCredit(number);
    }
}
