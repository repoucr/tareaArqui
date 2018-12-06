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
import ucr.if4100.sqlaccess.common.bean.has;

/**
 *
 * @author fabian
 */
public class HasData {
    public List<has> getHas() {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet hasResult = null;
        List<has> has = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.get_account}");
//            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    hasResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (hasResult.next()) {
                has newHas = new has();

                newHas.setIdClient(hasResult.getString("id_client"));
                newHas.setNameClient(hasResult.getString("name_client"));
                newHas.setIdAccount(hasResult.getString("id_account"));
                newHas.setNumberAccount(hasResult.getString("number_account"));

                has.add(newHas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (hasResult != null) {
                try {
                    hasResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return has;
    }

    public void insertHas(String idClient, String nameClient, String idAccount, String numberAccount) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.insert_has_(?,?,?,?)}");
            spCall.setString("id_client", idClient);
            spCall.setString("name_client", nameClient);
            spCall.setString("id_account", idAccount);
            spCall.setString("number_account", numberAccount);
            
            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteHasByIdClient(String id) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_has_by_id_client(?)}");
            spCall.setString("id_client", id);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteHasByIdAccount(String id) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_has_by_id_account(?)}");
            spCall.setString("id_account", id);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteHasByNumberAccount(String number) {
        Connection conn = null;
        CallableStatement spCall = null;

        try {
            conn = DatabaseConnection.getDatabaseConnection();
            spCall = conn.prepareCall("{CALL dbo.delete_has_by_number_account(?)}");
            spCall.setString("number_account", number);

            boolean results = spCall.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HasData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
