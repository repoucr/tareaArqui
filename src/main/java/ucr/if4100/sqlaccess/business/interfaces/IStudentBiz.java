/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.interfaces;

import java.util.List;
import ucr.if4100.sqlaccess.common.bean.Section;
import ucr.if4100.sqlaccess.common.bean.Student;

/**
 *
 * @author Equipo
 */
public interface IStudentBiz {
    
    List<Student> getStudents();
    
    Boolean insertStudent(String id, String name, String department, int totCredits);
    
    Boolean registerStudentInSection(String studentId, String courseId, String secId, String semester, int year);
    
}
