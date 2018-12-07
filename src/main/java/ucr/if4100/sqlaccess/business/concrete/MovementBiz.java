/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.account;
import ucr.if4100.sqlaccess.common.bean.movement;
import ucr.if4100.sqlaccess.data.AccountData;
import ucr.if4100.sqlaccess.data.MovementData;

/**
 *
 * @author fabian
 */
public class MovementBiz {
    private MovementData _dataAccess;
    
    public MovementBiz(){
        this._dataAccess = new MovementData();
    }
    public  List<movement> getMovements() {
        return _dataAccess.getMovements();
    }
    
//    public void insertMovement(String id, int amount, String date, String detail,String idAccount,String idClient,String clientName){
//        _dataAccess.insertMovement(id, amount, date, detail, idAccount, idClient, clientName);
//    }
//    
//    public void deleteMovement(String id){
//        _dataAccess.deleteMovement(id);
//    }
    
 
}
