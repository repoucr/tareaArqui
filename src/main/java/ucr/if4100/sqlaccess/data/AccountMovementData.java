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
import ucr.if4100.sqlaccess.common.bean.accountMovement;

/**
 *
 * @author fabian
 */
public class AccountMovementData {
    public List<accountMovement> getAccountMovement() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet accountMovementResult = null;
        List<accountMovement> accountMovements = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_account_movement}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    accountMovementResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (accountMovementResult.next()) {
                accountMovement newAccountMovement = new accountMovement();

                newAccountMovement.setIdMovement(accountMovementResult.getString("id_movement"));
                newAccountMovement.setIdAccount(accountMovementResult.getString("id_account"));
                newAccountMovement.setNumberAccount(accountMovementResult.getString("number_account"));

                accountMovements.add(newAccountMovement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (accountMovementResult != null) {
                try {
                    accountMovementResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return accountMovements;
    }
    
    public void makeDeposit(String id, int amount, String date, String detail, String idAccount,String numberAccount, String idClient, String clientName,String currency) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.make_deposit(?,?,?,?,?,?,?,?,?)}");
            spCall.setString("id", id);
            spCall.setInt("amount",  amount);
            spCall.setString("date", date);
            spCall.setString("detail", detail);
            spCall.setString("id_account",idAccount);
            spCall.setString("number_account",numberAccount);
            spCall.setString("id_client",idClient);
            spCall.setString("client_name",clientName);
            spCall.setString("currency",currency);
            
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovementData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void insertAccountMovement(String idMovement, String idAccount, String numberAccount) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.insert_account_movement(?,?,?)}");
//            spCall.setString("id_movement", idMovement);
//            spCall.setString("id_account", idAccount);
//            spCall.setString("number_account", numberAccount);
//            
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteAccountMovementByIdMovement(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_account_movement_by_id_movement(?)}");
//            spCall.setString("id_movement", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteAccountMovementByIdAccount(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_account_movement_by_id_account(?)}");
//            spCall.setString("id_account", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void deleteAccountMovementByNumberAccount(String number) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_account_movement_by_number_account(?)}");
//            spCall.setString("number_account", number);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
