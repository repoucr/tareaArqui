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
import ucr.if4100.sqlaccess.common.bean.account;


/**
 *
 * @author fabian
 */
public class AccountData {

    public List<account> getAccounts() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet accountResult = null;
        List<account> accounts = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_account}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    accountResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (accountResult.next()) {
                account newAccount = new account();

                newAccount.setId(accountResult.getString("id"));
                newAccount.setNumber(accountResult.getString("number"));
                newAccount.setAccountBalance(Integer.parseInt(accountResult.getString("account_balance")));
                newAccount.setCurrency(accountResult.getString("currency"));

                accounts.add(newAccount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (accountResult != null) {
                try {
                    accountResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return accounts;
    }

    public void insertAccount(String id, String number, int accountBalance, String currency) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.insert_account(?,?,?,?)}");
            spCall.setString("id", id);
            spCall.setString("number", number);
            spCall.setInt("account_balance", accountBalance);
            spCall.setString("currency", currency);
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccountById(String id) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_account_by_id(?)}");
            spCall.setString("id", id);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccountByNumber(String number) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_account_by_number(?)}");
            spCall.setString("number", number);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
