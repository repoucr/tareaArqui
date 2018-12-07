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
import ucr.if4100.sqlaccess.common.bean.transferAccounts;

/**
 *
 * @author fabian
 */
public class TransferAccountData {
    public List<transferAccounts> getTransferAccount() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet transferAccountResult = null;
        List<transferAccounts> transferAccount = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_transfer_accounts}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    transferAccountResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (transferAccountResult.next()) {
                transferAccounts newTransferAccounts = new transferAccounts();

                newTransferAccounts.setIdTransfer(transferAccountResult.getString("id_transfer"));
                newTransferAccounts.setIdAccountToDebit(transferAccountResult.getString("id_account_to_debit"));
                newTransferAccounts.setIdAccountToCredit(transferAccountResult.getString("id_account_to_credit"));
                newTransferAccounts.setNumberAccountToDebit(transferAccountResult.getString("number_account_to_debit"));
                newTransferAccounts.setNumberAccountToCredit(transferAccountResult.getString("number_account_to_credit"));
                transferAccount.add(newTransferAccounts);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (transferAccountResult != null) {
                try {
                    transferAccountResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return transferAccount;
    }
    
//CREATE PROCEDURE make_transfer (
//@id_transfer varchar(10),
//@amount NUMERIC,
//@date DATE,
//@detail VARCHAR (200),
//@id_account_to_debit VARCHAR (18),
//@id_account_to_credit VARCHAR (18),
//@number_account_to_debit VARCHAR (12),
//@number_account_to_credit VARCHAR (12),
//@id_client VARCHAR (9),
//@client_name VARCHAR (200),
//@currency VARCHAR (10)
    public void makeTransfer(String idTransfer, String amount, String date, String detail, String idAccountToDebit,String idAccountToCredit,String numberAccountToDebit,String numberAccountToCredit,String idClient,String clientName,String currency) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.make_transfer(?,?,?,?,?,?,?,?,?,?,?)}");
            spCall.setString("id_transfer", idTransfer);
            spCall.setString("amount", amount);
            spCall.setString("date", date);
            spCall.setString("detail", detail);
            spCall.setString("id_account_to_debit", idAccountToDebit);
            spCall.setString("id_account_to_credit", idAccountToCredit);
            spCall.setString("number_account_to_debitt", numberAccountToDebit);
            spCall.setString("number_account_to_credit", numberAccountToCredit);
            spCall.setString("id_client", idClient);
            spCall.setString("client_name", clientName);
            spCall.setString("currency", currency);
            
            
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    public void insertTransferAccount(String idTransfer, String idAccountToDebit, String idAccountToCredit, String numberAccountToDebit, String numberAccountToCredit) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.insert_transfer_accounts(?,?,?,?,?)}");
//            spCall.setString("id_transfer", idTransfer);
//            spCall.setString("id_account_to_debit", idAccountToDebit);
//            spCall.setString("id_account_to_credit", idAccountToCredit);
//            spCall.setString("number_account_to_debit", numberAccountToDebit);
//            spCall.setString("number_account_to_credit", numberAccountToCredit);
//            
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteTransferAccountByIdTransfer(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_id_transfer(?)}");
//            spCall.setString("id_transfer", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void insertTransferAccount(String idTransfer, String idAccountToDebit, String idAccountToCredit, String numberAccountToDebit, String numberAccountToCredit) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.insert_transfer_accounts(?,?,?,?,?)}");
//            spCall.setString("id_transfer", idTransfer);
//            spCall.setString("id_account_to_debit", idAccountToDebit);
//            spCall.setString("id_account_to_credit", idAccountToCredit);
//            spCall.setString("number_account_to_debit", numberAccountToDebit);
//            spCall.setString("number_account_to_credit", numberAccountToCredit);
//            
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteTransferAccountByIdTransfer(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_id_transfer(?)}");
//            spCall.setString("id_transfer", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteTransferAccountByIdAccountToDebit(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_id_account_to_debit(?)}");
//            spCall.setString("id_account_to_debit", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void deleteTransferAccountByIdAccountToCredit(String id) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_id_account_to_credit(?)}");
//            spCall.setString("id_account_to_credit", id);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(TransferAccountData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void deleteTransferAccountByNumberAccountToDebit(String number) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_number_account_to_debit(?)}");
//            spCall.setString("number_account_to_debit", number);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void deleteTransferAccountByNumberAccountToCredit(String number) {
//        Connection conn = null;
//        CallableStatement spCall = null;
//
//        try {
//            conn = DatabaseConnection.getDatabaseConnection();
//            spCall = conn.prepareCall("{CALL dbo.delete_transfer_accounts_by_number_account_to_credit(?)}");
//            spCall.setString("number_account_to_credit", number);
//
//            boolean results = spCall.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountMovementData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
