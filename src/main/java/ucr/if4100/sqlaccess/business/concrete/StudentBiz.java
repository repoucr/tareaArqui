/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.business.interfaces.IStudentBiz;
import ucr.if4100.sqlaccess.common.bean.Section;
import ucr.if4100.sqlaccess.common.bean.Student;
import ucr.if4100.sqlaccess.data.StudentDataProvider;

/**
 *
 * @author Equipo
 */
public class StudentBiz implements IStudentBiz {

    private StudentDataProvider _dataProvider;

    public StudentBiz() {
        this._dataProvider = new StudentDataProvider();
    }

    @Override
    public List<Student> getStudents() {
        return this._dataProvider.getStudents();
    }

    @Override
    public Boolean insertStudent(String id, String name, String department, int totCredits) {
        Student newStudent = new Student(id, name, department, totCredits);
        return _dataProvider.insertStudent(newStudent);
    }

    @Override
    public Boolean registerStudentInSection(String studentId, String courseId, String secId, String semester, int year) {
        Student student = new Student();
        student.setId(studentId);
        
        Section section = new Section(courseId, secId, semester, year, null, null, null);
        
        return _dataProvider.registerStudentInSection(student, section);
    }

}
