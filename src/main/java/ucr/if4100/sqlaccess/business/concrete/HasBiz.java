/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.has;
import ucr.if4100.sqlaccess.data.HasData;

/**
 *
 * @author fabian
 */
public class HasBiz {
    private HasData _dataAccess;
    
    public HasBiz(){
        this._dataAccess = new HasData();
    }
    public  List<has> getClients() {
        return _dataAccess.getHas();
    }
    
    public void insertHas(String idClient, String nameClient, String idAccount, String numberAccount){
        _dataAccess.insertHas(idClient, nameClient, idAccount, numberAccount);
    }
    
    public void deleteHasByIdClient(String id){
        _dataAccess.deleteHasByIdClient(id);
    }
    public void deleteHasByIdAccount(String id){
        _dataAccess.deleteHasByIdAccount(id);
    }
    
    public void deleteHasByNumberAccount(String number){
         _dataAccess.deleteHasByNumberAccount(number);
    }
}
