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
import ucr.if4100.sqlaccess.common.bean.movement;

/**
 *
 * @author fabian
 */
public class MovementData {
    public List<movement> getMovements() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet movementResult = null;
        List<movement> movements = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_movement}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    movementResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (movementResult.next()) {
                movement newMovement = new movement();

                newMovement.setId(movementResult.getString("id"));
                newMovement.setAmount(Integer.parseInt(movementResult.getString("amount")));
                newMovement.setDate(movementResult.getString("date"));
                newMovement.setDetail(movementResult.getString("detail"));
                newMovement.setIdAccount(movementResult.getString("id_account"));
                newMovement.setIdClient(movementResult.getString("id_client"));
                newMovement.setClientName(movementResult.getString("client_name"));
                
                movements.add(newMovement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (movementResult != null) {
                try {
                    movementResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return movements;
    }

    public void insertMovement(String id, int amount, String date, String detail, String idAccount, String idClient, String clientName) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.insert_movement(?,?,?,?,?,?,?)}");
            spCall.setString("id", id);
            spCall.setInt("amount",  amount);
            spCall.setString("date", date);
            spCall.setString("detail", detail);
            spCall.setString("id_account",idAccount);
            spCall.setString("id_client",idClient);
            spCall.setString("client_name",clientName);
            
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMovement(String id) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_movement(?)}");
            spCall.setString("id", id);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
