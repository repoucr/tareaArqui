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
import ucr.if4100.sqlaccess.common.bean.transfer;

/**
 *
 * @author fabian
 */
public class TransferData {

    public List<transfer> getTransfers() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet transferResult = null;
        List<transfer> transfers = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_transfer}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    transferResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (transferResult.next()) {
                transfer newTransfer = new transfer();

                newTransfer.setId(transferResult.getString("id"));
                newTransfer.setAmount(Integer.parseInt(transferResult.getString("amount")));
                newTransfer.setDate(transferResult.getString("date"));
                newTransfer.setDetail(transferResult.getString("detail"));

                transfers.add(newTransfer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (transferResult != null) {
                try {
                    transferResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return transfers;
    }

    public void insertTransfer(String id, int amount, String detail, String date) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.insert_transfer(?,?,?,?)}");
            spCall.setString("id", id);
            spCall.setInt("amount", amount);
            spCall.setString("detail", detail);
            spCall.setString("date", date);
            
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTransfer(String id) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_transfer(?)}");
            spCall.setString("id", id);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TransferData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
