/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucr.if4100.sqlaccess.common.bean.client;

public class ClientData {
     public List<client> getClients() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet clientResult = null;
        List<client> clients = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_clients}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    clientResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (clientResult.next()) {
                client newClient = new client();
                
                newClient.setId(clientResult.getString("ID"));
                newClient.setFirstName(clientResult.getString("first_name"));
                newClient.setLastName(clientResult.getString("last_name"));
                newClient.setAddress(clientResult.getString("address"));
                newClient.setBirthdate(clientResult.getString("birthday"));

                clients.add(newClient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (clientResult != null) {
                try {
                    clientResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return clients;
    }

    
}
