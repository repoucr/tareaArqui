/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.accountMovement;
import ucr.if4100.sqlaccess.data.AccountMovementData;

/**
 *
 * @author fabian
 */
public class AccountMovementBiz {
    private AccountMovementData _dataAccess;
    
    public AccountMovementBiz(){
        this._dataAccess = new AccountMovementData();
    }
    public  List<accountMovement> getAccountMovements() {
        return _dataAccess.getAccountMovement();
    }
    
    public void insertAccountMovement(String idMovement, String idAccount, String numberAccount){
        _dataAccess.insertAccountMovement(idMovement, idAccount, numberAccount);
               
    }
    
    public void deleteAccountMovementByIdMovement(String id){
        _dataAccess.deleteAccountMovementByIdMovement(id);
    }
    public void deleteAccountMovementByIdAccount(String id){
        _dataAccess.deleteAccountMovementByIdAccount(id);
    }
    
    public void deleteAccountMovementByNumberAccount(String number){
         _dataAccess.deleteAccountMovementByNumberAccount(number);
    }
}
