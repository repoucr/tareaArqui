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
import ucr.if4100.sqlaccess.common.bean.Instructor;

/**
 *
 * @author Equipo
 */
public class InstructorDataAccess {

    public List<Instructor> getInstrutorsByDepartment(String deptName) {
        Connection conn = null;
        CallableStatement spCall = null;
        ResultSet instructorResult = null;
        List<Instructor> instructors = new ArrayList<>();

        try {

            conn = DatabaseConnection.getDatabaseConnection();

            spCall = conn.prepareCall("{CALL dbo.prGetInstructorsByDepartment(?)}");
            spCall.setString("dept_name", deptName);

            boolean results = spCall.execute();

            int rowAffected = 0;

            // Protect against lack of SET NOCOUNT=ON
            while (results || rowAffected != -1) {
                if (results) {
                    instructorResult = spCall.getResultSet();
                    break;
                } else {
                    rowAffected = spCall.getUpdateCount();
                }
                results = spCall.getMoreResults();
            }

            while (instructorResult.next()) {
                Instructor newInstructor = new Instructor();
                
                newInstructor.setId(instructorResult.getString("ID"));
                newInstructor.setName(instructorResult.getString("name"));
                newInstructor.setDepartment(instructorResult.getString("dept_name"));
                newInstructor.setSalary(instructorResult.getDouble("salary"));

                instructors.add(newInstructor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstructorDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (instructorResult != null) {
                try {
                    instructorResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorDataAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorDataAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return instructors;
    }

}
