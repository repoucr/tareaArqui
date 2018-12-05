/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.business.interfaces.ClientInterface;
import ucr.if4100.sqlaccess.common.bean.client;
import ucr.if4100.sqlaccess.data.ClientData;

/**
 *
 * @author Equipo
 */
public class ClientBiz implements ClientInterface{
    
    private ClientData _dataAccess;
    
    public ClientBiz(){
        this._dataAccess = new ClientData();
    }
    public  List<client> getClients() {
        return _dataAccess.getClients();
    }

    @Override
    public void insertClient(String id, String firstName, String lastName, String address, String birthDate) {
         client newClient = new client(id, firstName, lastName, address, birthDate);
        _dataAccess.insertClient(id, firstName, lastName, address, birthDate);
    }

    @Override
    public void deleteClient(String id) {
       _dataAccess.deleteClient(id);
    }

    @Override
    public void updateClient(String id) {
//        client newClient = new client(id, firstName, lastName, address, birthDate);
//        _dataAccess.insertClient(id, firstName, lastName, address, birthDate);
    }

   
    
}
