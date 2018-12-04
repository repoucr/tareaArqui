/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.test;

import java.util.List;
import ucr.if4100.sqlaccess.business.concrete.InstructorBiz;
import ucr.if4100.sqlaccess.business.concrete.StudentBiz;
import ucr.if4100.sqlaccess.business.interfaces.IInstructorBiz;
import ucr.if4100.sqlaccess.business.interfaces.IStudentBiz;
import ucr.if4100.sqlaccess.common.bean.Instructor;
import ucr.if4100.sqlaccess.common.bean.Student;

/**
 *
 * @author Equipo
 */
public class ConnectionTest {
    
    public static void main(String[] args){
        //Very beginning of the Dependency Injection principle
        IStudentBiz studentBiz = new StudentBiz();
        IInstructorBiz instructorBiz = new InstructorBiz();
        
        // Iterate throw the students stored in the data base
        List<Student> students = studentBiz.getStudents();
        List<Instructor> instructors = instructorBiz.getInstructorByDepartment("Comp. Sci.");
        
        for (Student student : students) {
            String line = String.format("Student Id: %s, Name: %s, Department: %s, Total Credits: %s", student.getId(),student.getName(),student.getDepartment(),student.getTotCredits());
            System.out.println(line);
        }
        
        // Insert new Student
//        Boolean wasInsertedCorrectly = studentBiz.insertStudent("B6781", "Hans Villalobos", "Comp. Sci.", 140);
//        System.out.println("Was the user successfully inserted?" + (wasInsertedCorrectly ? " yes": " no"));

        //Use an stored procedure in order to enroll an student in a course
//        Boolean wasRegisteredCorrectly = studentBiz.registerStudentInSection("B6781", "CS-101", "1", "Spring", 2010);
//        System.out.println("Was the student registed correctly?" + (wasRegisteredCorrectly ? "yes" : "no"));
    
        System.out.println("This is the list of all the instructors for that department:");
        for (Instructor instructor : instructors) {
            String line = String.format("Instructor Id: %s, Name: %s, Department Name: %s, Salary: %s" 
                    , instructor.getId()
                    , instructor.getName()
                    , instructor.getDepartment()
                    , instructor.getSalary());
            System.out.println(line);
        }
    }
    
}
