/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.interfaces;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.client;

/**
 *
 * @author fabian
 */
public interface ClientInterface {
    public  List<client> getClients();
}
