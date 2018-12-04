/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.business.concrete;

import java.util.List;
import ucr.if4100.sqlaccess.business.interfaces.IInstructorBiz;
import ucr.if4100.sqlaccess.common.bean.Instructor;
import ucr.if4100.sqlaccess.data.InstructorDataAccess;

/**
 *
 * @author Equipo
 */
public class InstructorBiz implements IInstructorBiz{
    
    private InstructorDataAccess _dataAccess;
    
    public InstructorBiz(){
        _dataAccess = new InstructorDataAccess();
    }

    @Override
    public List<Instructor> getInstructorByDepartment(String deptName) {
        return _dataAccess.getInstrutorsByDepartment(deptName);
    }
    
}
