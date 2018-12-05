/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.transfer;
import ucr.if4100.sqlaccess.data.TransferData;

/**
 *
 * @author fabian
 */
public class TransferBiz {
    private TransferData _dataAccess;
    
    public TransferBiz(){
        this._dataAccess = new TransferData();
    }
    public  List<transfer> getMovements() {
        return _dataAccess.getTransfers();
    }
    
    public void insertMovement(String id, int amount, String detail, String date){
        _dataAccess.insertTransfer(id, amount, detail, date);
    }
    
    public void deleteMovement(String id){
        _dataAccess.deleteTransfer(id);
    }
}
