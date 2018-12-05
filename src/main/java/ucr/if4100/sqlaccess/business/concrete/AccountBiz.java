/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.account;
import ucr.if4100.sqlaccess.data.AccountData;

/**
 *
 * @author fabian
 */
public class AccountBiz {
    
    private AccountData _dataAccess;
    
    public AccountBiz(){
        this._dataAccess = new AccountData();
    }
    public  List<account> getClients() {
        return _dataAccess.getAccounts();
    }
    
    public void insertAccount(String id, String number, int accountBalance, String currency){
        _dataAccess.insertAccount(id, number, accountBalance, currency);
    }
    
    public void deleteAccountById(String id){
        _dataAccess.deleteAccountById(id);
    }
    
    public void deleteAccountByNumber(String number){
         _dataAccess.deleteAccountByNumber(number);
    }
}
