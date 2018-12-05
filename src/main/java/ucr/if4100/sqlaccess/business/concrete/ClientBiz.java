/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.client;
import ucr.if4100.sqlaccess.data.ClientData;

/**
 *
 * @author Equipo
 */
public class ClientBiz {
    
    private ClientData _dataAccess;
    
    public ClientBiz(){
        _dataAccess = new ClientData();
    }
    public static List<client> getClients() {
        return _dataAccess.getClients();
    }
    
}
