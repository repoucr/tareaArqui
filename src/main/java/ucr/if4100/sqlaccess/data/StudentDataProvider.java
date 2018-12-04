/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucr.if4100.sqlaccess.common.bean.Section;
import ucr.if4100.sqlaccess.common.bean.Student;

/**
 *
 * @author Equipo
 */
public class StudentDataProvider {

    public List<Student> getStudents() {
        Connection conn = null;
        ResultSet queryResult = null;
        List<Student> students = new ArrayList<>();

        try {
            conn = DatabaseConnection.getDatabaseConnection();

            PreparedStatement getStudent = conn.prepareStatement("SELECT ID, name, dept_name, tot_cred FROM student");

            queryResult = getStudent.executeQuery();

            while (queryResult.next()) {
                Student student = new Student();

                student.setId(queryResult.getString("ID"));
                student.setName(queryResult.getString("name"));
                student.setDepartment(queryResult.getString("dept_name"));
                student.setTotCredits(queryResult.getInt("tot_cred"));

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return students;

    }
    
    public boolean insertStudent(Student newStudent){
        Connection conn = null;
        boolean wasSuccessfullyUpdate = false;
        PreparedStatement insertStudent = null;
        
        try{
            conn = DatabaseConnection.getDatabaseConnection();
            
            String insertStudentStm = String.format("INSERT INTO STUDENT(ID, name, dept_name, tot_cred) VALUES('%s', '%s', '%s', %s)"
                                                    , newStudent.getId()
                                                    , newStudent.getName()
                                                    , newStudent.getDepartment()
                                                    , newStudent.getTotCredits());
            insertStudent = conn.prepareStatement(insertStudentStm);
            int insertResult = insertStudent.executeUpdate();
            
            if(insertResult == 1){
                wasSuccessfullyUpdate = true;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(insertStudent != null){
                try {
                    insertStudent.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return wasSuccessfullyUpdate;
    }
    
    public boolean registerStudentInSection(Student student, Section section){
        Connection conn = null;
        CallableStatement spCall = null;
        Boolean successfulExecution = false;
        
        try {
            conn = DatabaseConnection.getDatabaseConnection();
            
            spCall = conn.prepareCall("{? = CALL dbo.registerStudent(?,?,?,?,?,?)}");
            spCall.setString("s_id", student.getId());
            spCall.setString("s_courseid", section.getCourseId());
            spCall.setString("s_secId", section.getSecId());
            spCall.setString("s_semester", section.getSemester());
            spCall.setInt("s_year", section.getYear());
            
            spCall.registerOutParameter("errorMsg", Types.VARCHAR);
            spCall.registerOutParameter(1, Types.INTEGER);
            
            spCall.execute();
            
            String errorMessage = spCall.getString("errorMsg");
            System.out.println("This is the error message: " + errorMessage);
            
            int spReturn = spCall.getInt(1);
            if(spReturn == 0){
                successfulExecution = true;
            }
            
            System.out.println("Store procedure return " + spReturn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(spCall != null){
                try {
                    spCall.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return successfulExecution;
    }

}
